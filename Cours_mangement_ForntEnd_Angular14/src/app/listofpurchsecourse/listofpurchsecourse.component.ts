import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listofpurchsecourse',
  templateUrl: './listofpurchsecourse.component.html',
  styleUrl: './listofpurchsecourse.component.css'
})
export class ListofpurchsecourseComponent {
  allpurchasecourse:any
  constructor(private http: HttpClient){}

ngOnInit(){ 
  let response = this.http.get("http://localhost:9090/allpurchasecourses");
  response.subscribe((data)=>this.allpurchasecourse=data);
}


}
   









 
