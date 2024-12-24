import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { AuthserviceService } from '../services/authservice.service';

@Component({
  selector: 'app-coursespurchasebystudent',
  templateUrl: './coursespurchasebystudent.component.html',
  styleUrl: './coursespurchasebystudent.component.css'
})
export class CoursespurchasebystudentComponent {
  student!: any
  studentId! :any;
  coursespurchasebystudent: any
  constructor(private http: HttpClient,private authService:AuthserviceService) { }


//   this.student = this.authService.getUserDetails().subscribe();
// this.studentId=this.student.id


  purchasecourse(): void {
    if (!this.studentId) {
      console.error('Student ID is undefined.');
      return;
    }
  
    this.http.get<any>(`http://localhost:9090/coursepurchase/${this.studentId}`)
      .subscribe(
        (data) => {
          this.coursespurchasebystudent = data;
          console.log('Purchase data:', data);
        },
        (error) => {
          console.error('Error fetching course purchase data:', error);
        }
      );
  }
  

  
  ngOnInit() {
    this.student = this.authService.getUserDetails().subscribe();
    this.studentId=this.student.id

    console.log(this.student,"====course perchase by sutudent  and student delatis")
    this.purchasecourse();
    // let response = this.http.get("http://localhost:9090/studentdetails");
    // response.subscribe((data) => this.student = data);

    // // Retrieve token from local storage
    // const token = localStorage.getItem('token');
    // if (token) {
    //   // Set up HTTP headers with the JWT token
    //   const headers = new HttpHeaders({
    //     'Authorization': token
    //   });

       
    // } else {
    //   console.log('Token not found');
    //   // Handle case where token is not available
    // }
  }

 








} 