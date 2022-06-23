import { CursosService } from './../../service/cursos.service';
import { FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cursos-details',
  templateUrl: './cursos-details.component.html',
  styleUrls: ['./cursos-details.component.scss']
})
export class CursosDetailsComponent implements OnInit {

  constructor(
    private service: CursosService,
    private route: ActivatedRoute,
    private router: Router,
    private form: FormBuilder,
  ) { }

  isEdit = false;
  id!: number;

  cursosForm = this.form.group({
    nome: [null, [Validators.required]],
    descricao: [],
    cargaHoraria: [null, [Validators.required]],
    preco: [null, [Validators.required]],
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
        this.cursosForm.patchValue(response);
      }
    });
  }

  changePage(x: string) {
    this.router.navigate([x])
  }

 create() {
  const data = this.cursosForm.value;
  this.service.create(data).subscribe({
    next: () => {
      alert("Curso adicionado com sucesso!");
      this.cursosForm.reset();
    },
    error: () => {
      alert("O curso não pôde ser adicionado.");
    },
  });
 }

 save() {
  const data = this.cursosForm.value;
  this.service.update(data, this.id).subscribe({
    next: () => {
      alert("Registro atualizado com sucesso!");
      this.router.navigate(['/cursos']);
    },
    error: () => {
      alert("O registro não pôde ser atualizado.");
    }
  });
 }

}
