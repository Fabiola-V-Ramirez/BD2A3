import { environment } from './../../../environments/environment.prod';
import { HttpClient, HttpParams } from '@angular/common/http';
import { PageEvent } from '@angular/material/paginator';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AlunosService {

  constructor(private http: HttpClient) { }

  getByNome (nome: string) {
    let params = new HttpParams().append('nome', nome);
    return this.http.get<any>(`${environment.apiUrl}/api/alunos`, {params});
  }

  getByMatricula (matricula: number) {
    return this.http.get<any>(`${environment.apiUrl}/api/alunos/${matricula}`);
  }

  findAllPaginated (
    pager: PageEvent,
    query?: string){
    let params = new HttpParams()
      .append('page', pager.pageIndex)
      .append('size', pager.pageSize);
    if (query) params = params.append('query', query);
    return this.http.get<any>(`${environment.apiUrl}/api/alunos/all`, {params});
    }


  create (formData: Object) {
    return this.http.post<any>(`${environment.apiUrl}/api/alunos`, formData);
  }

  update (formData: Object, matricula: number) {
    return this.http.put<any>(`${environment.apiUrl}/api/alunos/${matricula}`, formData);
  }

  delete (matricula: number) {
    return this.http.delete<any>(`${environment.apiUrl}/api/alunos/${matricula}`);
  }

}
