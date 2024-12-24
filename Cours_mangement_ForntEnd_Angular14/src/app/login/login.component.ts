import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
// import { Router } from 'express';
import { MatSnackBar } from '@angular/material/snack-bar';

import { Router } from '@angular/router';
import { ListofcoursesService } from '../services/listofcourses.service';
import { AuthserviceService } from '../services/authservice.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  user: any;



  loginForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    showPassword: new FormControl()
  });
  islogin: boolean = false;

  constructor(
    private snackBar: MatSnackBar, 
    private router: Router, 
    private http: HttpClient, 
    private formBuilder: FormBuilder, 
    private authservice: AuthserviceService) {

    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      showPassword: [false] // Initialize checkbox state
    });
  }
  ngOnInit(): void {

  }



  showErrorSnackBar(message: string): void {
    this.snackBar.open(message, 'Close', {
      duration: 3000, // Duration in milliseconds
      verticalPosition: 'top', // Positioning of the snackbar
      panelClass: ['error-snackbar'] // Custom CSS class for styling
    });
  }


  onSubmit(): void {
    if (this.loginForm.invalid) {
      // Form validation failed, do nothing or provide feedback to the user
      return;
    }

    const email = this.loginForm.get('username')?.value;
    const password = this.loginForm.get('password')?.value;
    const showPassword = this.loginForm.get('password')?.value;
    const formData = {
      email: email,
      password: password,
      showPassword: showPassword
    };

    // Adjust the URL to match your Spring Boot backend endpoint
    this.http.post<any>('http://localhost:9090/signin', formData).subscribe(
      response => {


        // Assuming your backend returns a token upon successful login
        const token = response.accessToken;

        localStorage.setItem('token', token);
        this.authservice.updateLoginStatus(true);


        this.user = this.authservice.getUserDetails();

        console.log("user pring in login method ",this.user );

        const role = this.user.role;
        if(role){
          this.authservice.updateUserRole(role);
        }

        if (token&&role) {
          console.log('Authentication successful');

          // Redirect based on user role
          if (role === 'ROLE_ADMIN') {
            // this.location.reload();
            // window.location.reload();
            this.islogin=true// Redirect to add course page for admin
            this.router.navigate(['/addcourse']); 
          } else {
            this.router.navigate(['/listofcourses']);
            this.islogin=true// Redirect to add course page for admin
             // Redirect to course list for normal users
          }
        } else {
          console.log('Invalid credentials');
          // Optionally display an error message to the user
        }
      },
      error => {
        console.error('Error:', error);
        // Handle the error accordingly, e.g., display an error message
      }
    );
  }



}