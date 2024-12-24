import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ListofstudentsService } from '../services/listofstudents.service';

@Component({
  selector: 'app-userdata',
  templateUrl: './userdata.component.html',
  styleUrl: './userdata.component.css'
})
export class UserdataComponent {
    student:any
      constructor(private http: HttpClient,private listStudentService:ListofstudentsService){}
    
    ngOnInit(){ 
      this.getStudentDetails();
      // let response = this.http.get("http://localhost:9090/studentdetails");
      // response.subscribe((data)=>this.student=data);
    }

    getStudentDetails(){
      this.listStudentService.getAllStudent().subscribe(
        (response) => {
          if (response != null) {
            this.student = response; // Assuming response.data is an array
          } else {
            this.student = []; // Handle case where no data is available
          }
        },
        (error) => {
          console.log(error);
        }
      );
      
   
    }
    
}
