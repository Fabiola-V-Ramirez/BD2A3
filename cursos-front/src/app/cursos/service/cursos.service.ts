import { environment } from './../../../environments/environment.prod';
import { PageEvent } from '@angular/material/paginator';
import { HttpParams, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CursosService {

  constructor(private http: HttpClient) { }

  getById (id: number) {
    return this.http.get<any>(`${environment.apiUrl}/api/cursos/${id}`);
  }

  findAllPaginated (
    pager: PageEvent,
    query?: string){
    let params = new HttpParams()
      .append('page', pager.pageIndex)
      .append('size', pager.pageSize);
    if (query) params = params.append('query', query);
    return this.http.get<any>(`${environment.apiUrl}/api/cursos/all`, {params});
    }

  create (formData: Object) {
    return this.http.post<any>(`${environment.apiUrl}/api/cursos`, formData);
  }

  update (formData: Object, id: number) {
    return this.http.put<any>(`${environment.apiUrl}/api/cursos/${id}`, formData);
  }

  delete (id: number) {
    return this.http.delete<any>(`${environment.apiUrl}/api/cursos/${id}`);
  }

}
