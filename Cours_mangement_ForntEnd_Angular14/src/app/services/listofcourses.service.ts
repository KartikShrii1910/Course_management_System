import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Courses } from '../models/coueses.model';
import { PurchaseRecord } from '../models/puchaseRecord.model';
import { AuthserviceService } from './authservice.service';

@Injectable({
  providedIn: 'root'
})
export class ListofcoursesService {

  constructor(private http: HttpClient,private authService:AuthserviceService) { }
   token = localStorage.getItem('token');
   


  getAll(): Observable<Courses[]> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${this.authService.getUserDetails()?.token}`
    });
    return this.http.get<Courses[]>(`http://localhost:9090/coursesdetails`,{headers});
  }



  // getUserDetails(): Observable<any> {
  //   const token = localStorage.getItem('token');
  //   if (token) {
  //     // Set up HTTP headers with the JWT token
  //     const headers = new HttpHeaders({
  //       'Authorization': token
  //     });

  //     // Adjust the URL to match your backend API endpoint for fetching user details
  //     const apiUrl = 'http://localhost:9090/login/userdetails';

  //     return this.http.get<any>(apiUrl, { headers });
  //   } else {
  //     // If no token is available, return an empty Observable or throw an error
  //     return throwError('Token not found');
  //   }
  // }



  savePurchaseRecord(model:PurchaseRecord):Observable<any>{
    // alert("save puchash ervice")

    let url='http://localhost:9090/coursepurchase';
    return this.http.post(url,model);
  }


  // get(bankID: any): Observable<any> {

  //   //let request = {BankID : bankID};

  //   return this.http.get<any>(`${environment.baseApiUrl} ` + bankID,);
  // }


  // insert(request: StateRequest): Observable<any> {

  //   return this.http.post<any>(`${environment.baseApiUrl} `, request);

  //   //return this.http.post<any>(`${this.apiUrl}`, request);
  // }
  // update(request: StateRequest): Observable<any> {

  //   return this.http.post<any>(`${environment.baseApiUrl} `, request);

  //   //return this.http.post<any>(`${this.apiUrl}`, request);
  // }
}
