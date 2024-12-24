import { Injectable } from '@angular/core';
import { Students } from '../models/stundents.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListofstudentsService {
 

  constructor(private http: HttpClient) { }

  getAllStudent(): Observable<Students[]> {
   return this.http.get<Students[]>(`http://localhost:9090/studentdetails`);
  }
}
