import { PageEvent } from '@angular/material/paginator';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfessoresService {

  constructor(private http: HttpClient) { }

  getByMatricula (matricula: number) {
    return this.http.get<any>(`${environment.apiUrl}/api/professores/${matricula}`);
  }

  findAllPaginated (
    pager: PageEvent,
    query?: string){
    let params = new HttpParams()
      .append('page', pager.pageIndex)
      .append('size', pager.pageSize);
    if (query) params = params.append('query', query);
    return this.http.get<any>(`${environment.apiUrl}/api/professores/all`, {params});
    }


  create (formData: Object) {
    return this.http.post<any>(`${environment.apiUrl}/api/professores`, formData);
  }

  update (formData: Object, matricula: number) {
    return this.http.put<any>(`${environment.apiUrl}/api/professores/${matricula}`, formData);
  }

  delete (matricula: number) {
    return this.http.delete<any>(`${environment.apiUrl}/api/professores/${matricula}`);
  }

}
