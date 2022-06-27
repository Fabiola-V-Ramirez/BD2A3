import { PageEvent } from '@angular/material/paginator';
import { environment } from './../../../environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CoordenadoresService {

  constructor(private http: HttpClient) { }

  getById (id: number) {
    return this.http.get<any>(`${environment.apiUrl}/api/coordenadores/${id}`);
  }

  findAllPaginated (
    pager: PageEvent,
    query?: string){
    let params = new HttpParams()
      .append('page', pager.pageIndex)
      .append('size', pager.pageSize);
    if (query) params = params.append('query', query);
    return this.http.get<any>(`${environment.apiUrl}/api/coordenadores/all`, {params});
    }

}
