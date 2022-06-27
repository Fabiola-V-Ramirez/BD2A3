import { debounceTime } from 'rxjs';
import { PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { FormControl } from '@angular/forms';
import { CoordenadoresService } from './../../service/coordenadores.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-coordenadores-panel',
  templateUrl: './coordenadores-panel.component.html',
  styleUrls: ['./coordenadores-panel.component.scss']
})
export class CoordenadoresPanelComponent implements OnInit {


  constructor(
    private  service: CoordenadoresService
  ) { }

    filterControl = new FormControl('');
    totalLength!: number;
    pageSize = 5;
    page = 0;

    dataTable = new MatTableDataSource();
    displayedColumns = ['areaConhecimento', 'professor'];

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

}
