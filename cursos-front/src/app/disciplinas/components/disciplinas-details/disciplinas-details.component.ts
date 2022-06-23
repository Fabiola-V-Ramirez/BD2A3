import { FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { DisciplinasService } from './../../service/disciplinas.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-disciplinas-details',
  templateUrl: './disciplinas-details.component.html',
  styleUrls: ['./disciplinas-details.component.scss']
})
export class DisciplinasDetailsComponent implements OnInit {

  constructor(
    private service: DisciplinasService,
    private route: ActivatedRoute,
    private router: Router,
    private form: FormBuilder,
  ) { }

  isEdit = false;
  id!: number;

  disciplinasForm = this.form.group({
    nome: [null, [Validators.required]],
    cargaHoraria: [null, [Validators.required]],
    optativa: [null, [Validators.required]],
    areaConhecimento: [null, [Validators.required]],
   })

  ngOnInit(): void {
    this.route.params.subscribe({
      next: (params) => {
        this.isEdit = params['id'] !== 'new';
        this.id = params['id'];
      },
    });

    if (this.isEdit) {
      this.patch();
    }
  }

  patch() {
    this.service.getById(this.id).subscribe({
      next: (response) =>{
        this.disciplinasForm.patchValue(response);
      }
    });
  }

  changePage(x: string) {
    this.router.navigate([x])
  }

 create() {
  const data = this.disciplinasForm.value;
  this.service.create(data).subscribe({
    next: () => {
      alert("Disciplina adicionada com sucesso!");
      this.disciplinasForm.reset();
    },
    error: () => {
      alert("A disciplina não pôde ser adicionada.");
    },
  });
 }

 save() {
  const data = this.disciplinasForm.value;
  this.service.update(data, this.id).subscribe({
    next: () => {
      alert("Registro atualizado com sucesso!");
      this.router.navigate(['/disciplinas']);
    },
    error: () => {
      alert("O registro não pôde ser atualizado.");
    }
  });
 }

}
