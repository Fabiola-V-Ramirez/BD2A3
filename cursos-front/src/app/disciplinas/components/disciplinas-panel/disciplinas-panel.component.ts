import { debounceTime } from 'rxjs';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { DisciplinasService } from './../../service/disciplinas.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-disciplinas-panel',
  templateUrl: './disciplinas-panel.component.html',
  styleUrls: ['./disciplinas-panel.component.scss']
})
export class DisciplinasPanelComponent implements OnInit {

  constructor(
    private  service: DisciplinasService,
    private form: FormBuilder,
  ) { }

    filterControl = new FormControl('');
    totalLength!: number;
    pageSize = 5;
    page = 0;

    dataTable = new MatTableDataSource();
    displayedColumns = ['nome', 'optativa', 'cargaHoraria', 'areaConhecimento', 'action'];

    disciplinasForm = this.form.group({
      nome: [null, [Validators.required]],
      cargaHoraria: [null, [Validators.required]],
      optativa: [null, [Validators.required]],
      areaConhecimento: [null, [Validators.required]],
     });

     pageChange(pageEvent: PageEvent) {
      this.service
      .findAllPaginated(pageEvent, this.filterControl.value)
      .subscribe({
        next: (response) => {
          this.dataTable.data = response.content;
          this.totalLength = response.totalElements;
          this.pageSize = response.size;
          this.page = pageEvent.pageIndex;
        },
      error: () => console.log("Erro ao carregar!")
     });
  }

  ngOnInit(): void {
    this.filterControl.valueChanges.pipe(debounceTime(1000)).subscribe(query => {
      this.service.findAllPaginated({
        pageIndex: this.page,
        pageSize: this.pageSize,
        length: this.totalLength,
      },
        query).subscribe(response => {
          this.dataTable.data = response.content;
      });
    })

    this.pageChange({
      pageIndex: this.page,
      pageSize: this.pageSize,
      length: this.totalLength,
    });

  }

  delete(id: any) {
    let text = "Deseja excluir o registro?";
    if (confirm(text) == true) {
      this.service.delete(id).subscribe({
        next: () => {
          alert("Registro excluído com sucesso!");
          this.pageChange({
            pageIndex: this.page,
            pageSize: this.pageSize,
            length: this.totalLength,
          });
        },
        error: () => {
          alert("O registro não pôde ser excluído.");
        }
      });
    }
  }

}
