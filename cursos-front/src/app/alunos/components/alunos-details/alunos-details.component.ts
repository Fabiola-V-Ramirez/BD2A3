import { FormBuilder, Validators } from '@angular/forms';
import { AlunosService } from './../../service/alunos.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-alunos-details',
  templateUrl: './alunos-details.component.html',
  styleUrls: ['./alunos-details.component.scss']
})
export class AlunosDetailsComponent implements OnInit {

  constructor(
    private service: AlunosService,
    private route: ActivatedRoute,
    private router: Router,
    private form: FormBuilder,
  ) { }

  isEdit = false;
  matricula!: number;

  alunosForm = this.form.group({
    nome: [null, [Validators.required]],
    rg: [null, [Validators.required]],
    cpf: [null, [Validators.required]],
    email: [null, [Validators.required]],
    observacoes: [],
   })

  ngOnInit(): void {
    this.route.params.subscribe({
      next: (params) => {
        this.isEdit = params['id'] !== 'new';
        this.matricula = params['id'];
      },
    });

    if (this.isEdit) {
      this.patch();
    }
  }

  patch() {
    this.service.getByMatricula(this.matricula).subscribe({
      next: (response) =>{
        this.alunosForm.patchValue(response);
      }
    });
  }

  changePage(x: string) {
    this.router.navigate([x])
  }

 create() {
  const data = this.alunosForm.value;
  this.service.create(data).subscribe({
    next: () => {
      alert("Aluno adicionado com sucesso!");
      this.alunosForm.reset();
    },
    error: () => {
      alert("O aluno não pôde ser adicionado.");
    },
  });
 }

 save() {
  const data = this.alunosForm.value;
  this.service.update(data, this.matricula).subscribe({
    next: () => {
      alert("Registro atualizado com sucesso!");
      this.router.navigate(['/alunos']);
    },
    error: () => {
      alert("O registro não pôde ser atualizado.");
    }
  });
 }

}
