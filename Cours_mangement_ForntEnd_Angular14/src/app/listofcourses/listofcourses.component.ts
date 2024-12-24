import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import Swal from 'sweetalert2';
import { ListofcoursesService } from '../services/listofcourses.service';
import { Courses } from '../models/coueses.model';
import { AuthserviceService } from '../services/authservice.service';


@Component({
  selector: 'app-listofcourses',
  templateUrl: './listofcourses.component.html',
  styleUrl: './listofcourses.component.css'
})
export class ListofcoursesComponent implements OnInit {
  course: any;
  userId: any;
  user :any;
  constructor(private http: HttpClient, private listofcourseservice: ListofcoursesService,private authService:AuthserviceService) { }


  ngOnInit(): void {
    this.fillData();
    // this.getUserDetails();
    this.userDetails();



  }


  fillData(): void {
    this.listofcourseservice.getAll().subscribe(
      (response) => {
        if (response != null) {
          this.course = response; // Assuming response.data is an array
        } else {
          this.course = []; // Handle case where no data is available
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }


  // getUserDetails(): void {

  //   this.listofcourseservice.getUserDetails().subscribe(
  //     (response) => {
  //       if (response != null) {
  //         this.userId = response; // Assuming response.data is an array
  //       } else {
  //         this.userId = []; // Handle case where no data is available
  //       }
  //     },
  //     (error) => {
  //       console.log(error);
  //     }
  //   );

  // }


userDetails(){
  this.user = this.authService.getUserDetails().subscribe
  this.userId=this.user.id;
}









  // ngOnInit() {
  //   let response = this.http.get("http://localhost:9090/coursesdetails");
  //   response.subscribe((data) => this.course = data);

  //   // Retrieve token from local storage
  //   const token = localStorage.getItem('token');
  //   if (token) {
  //     // Set up HTTP headers with the JWT token
  //     const headers = new HttpHeaders({
  //       'Authorization': token
  //     });

  //     // Adjust the URL to match your backend API endpoint for fetching user details
  //     const apiUrl = 'http://localhost:9090/login/userdetails';

  //     // Send request to backend API to fetch user details
  //     this.http.get<any>(apiUrl, { headers }).subscribe(
  //       response => {
  //         // Extract email from the user details and assign it to userEmail
  //         this.userId = response.id;
  //         // Fetch courses after retrieving user details
  //         // this.fetchCourses();
  //       },
  //       error => {
  //         console.error('Error fetching user details:', error);
  //         // Handle error
  //       }
  //     );
  //   } else {
  //     console.log('Token not found');
  //     // Handle case where token is not available
  //   }
  // }



  registerForCourse(courseId: any): void {
    Swal.fire({
      title: 'Are you sure?',
      text: 'Do you want to purchase this course?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, purchase it!',
      cancelButtonText: 'Cancel',
      allowOutsideClick: false
    }).then((result) => {
      if (result.isConfirmed) {
        const userCourseRequest = {
          student_id: this.userId ,
          course_id: courseId
        };
  
        this.listofcourseservice.savePurchaseRecord(userCourseRequest).subscribe(
          (response) => {
            Swal.fire({
              title: 'Success!',
              text: 'You have successfully purchased the course.',
              icon: 'success',
              confirmButtonText: 'OK',
              allowOutsideClick: false
            });
            console.log('User registered for the course:', response);
          },
          (error) => {
            Swal.fire({
              title: 'Error!',
              text: 'There was an error purchasing the course. Please try again.',
              icon: 'error',
              confirmButtonText: 'OK'
            });
            console.error('Error registering user for the course:', error);
          }
        );
      }
    });
  }
  


  openCourseDetailsDialog(course: any): void {
    Swal.fire({
      title: course.courseName,
      html: `
        <p>${course.courseDescription}</p>
        <p>Duration: ${course.duration} months</p>
        <p>Fees: ${course.fees} INR</p>
      `,
      showCancelButton: true,
      confirmButtonText: 'Purchase',
      cancelButtonText: 'Cancel',
      allowOutsideClick: false,
    }).then((result) => {
      if (result.isConfirmed) {
        // Logic to handle purchase
        this.registerForCourse(course);
        Swal.fire({
          icon: 'success',
          title: 'Course Purchased!',
          text: 'Congratulations! You have successfully purchased the course.',
          confirmButtonText: 'OK',
          allowOutsideClick: false,
        });
        console.log('Course purchased:', course);
        // You can perform any other actions here after purchase confirmation
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        console.log('Purchase canceled');
      }
    });
  }










}
