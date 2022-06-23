import { debounceTime } from 'rxjs';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { ProfessoresService } from './../../service/professores.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-professores-panel',
  templateUrl: './professores-panel.component.html',
  styleUrls: ['./professores-panel.component.scss']
})
export class ProfessoresPanelComponent implements OnInit {

  constructor(
    private  service: ProfessoresService,
    private form: FormBuilder,
  ) { }

    filterControl = new FormControl('');
    totalLength!: number;
    pageSize = 5;
    page = 0;

    dataTable = new MatTableDataSource();
    displayedColumns = ['matricula', 'nome', 'rg', 'cpf', 'email', 'areaConhecimento', 'action'];

    ProfessoresForm = this.form.group({
      nome: [null, [Validators.required]],
      rg: [null, [Validators.required]],
      cpf: [null, [Validators.required]],
      email: [null, [Validators.required]],
      coordenador: [null, [Validators.required]],
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

  delete(matricula: any) {
    let text = "Deseja excluir o registro?";
    if (confirm(text) == true) {
      this.service.delete(matricula).subscribe({
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
