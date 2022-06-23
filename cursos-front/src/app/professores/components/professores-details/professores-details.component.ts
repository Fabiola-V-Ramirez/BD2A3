import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfessoresService } from './../../service/professores.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-professores-details',
  templateUrl: './professores-details.component.html',
  styleUrls: ['./professores-details.component.scss']
})
export class ProfessoresDetailsComponent implements OnInit {


  constructor(
    private service: ProfessoresService,
    private route: ActivatedRoute,
    private router: Router,
    private form: FormBuilder,
  ) { }

  isEdit = false;
  matricula!: number;

  professoresForm = this.form.group({
    matricula: [null, [Validators.required]],
    nome: [null, [Validators.required]],
    rg: [null, [Validators.required]],
    cpf: [null, [Validators.required]],
    email: [null, [Validators.required]],
    coordenador: [null, [Validators.required]],
    areaConhecimento: [null, [Validators.required]],
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
        this.professoresForm.patchValue(response);
      }
    });
  }

  changePage(x: string) {
    this.router.navigate([x])
  }

 create() {
  const data = this.professoresForm.value;
  this.service.create(data).subscribe({
    next: () => {
      alert("Professor adicionado com sucesso!");
      this.professoresForm.reset();
    },
    error: () => {
      alert("O professor não pôde ser adicionado.");
    },
  });
 }

 save() {
  const data = this.professoresForm.value;
  this.service.update(data, this.matricula).subscribe({
    next: () => {
      alert("Registro atualizado com sucesso!");
      this.router.navigate(['/professores']);
    },
    error: () => {
      alert("O registro não pôde ser atualizado.");
    }
  });
 }

}
