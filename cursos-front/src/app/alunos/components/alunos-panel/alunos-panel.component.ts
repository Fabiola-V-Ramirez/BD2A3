import { AlunosService } from './../../service/alunos.service';
import { MatTableDataSource } from '@angular/material/table';
import { Validators, FormControl, FormBuilder } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { debounceTime } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-alunos-panel',
  templateUrl: './alunos-panel.component.html',
  styleUrls: ['./alunos-panel.component.scss']
})
export class AlunosPanelComponent implements OnInit {

  constructor(
    private  service: AlunosService,
    private form: FormBuilder,
  ) { }

    filterControl = new FormControl('');
    totalLength!: number;
    pageSize = 5;
    page = 0;

    dataTable = new MatTableDataSource();
    displayedColumns = ['matricula', 'nome', 'rg', 'cpf', 'email', 'observacoes', 'action'];

    alunosForm = this.form.group({
      nome: [null, [Validators.required]],
      rg: [null, [Validators.required]],
      cpf: [null, [Validators.required]],
      email: [null, [Validators.required]],
      observacoes: [],
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
