import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { ListofcoursesService } from '../services/listofcourses.service';
import { Router } from '@angular/router';
import { AuthserviceService } from '../services/authservice.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {
  user: any = null;  // Store the user's data here
  role: string = '';
  islogin: boolean = false;
  isRoleAdmin: boolean = false;
  isNormalUser: boolean = false;
  
  constructor(private http: HttpClient, private router: Router, private authService: AuthserviceService) { }

  ngOnInit(): void {
    this.authService.LoginStatus$.subscribe(loginStatus => {
      this.islogin = loginStatus;
      this.getUserDetails();
    });
    // console.log("IsLogin", this.islogin);

    this.authService.LoginStatus$.subscribe(loginStatus => {
      this.islogin = loginStatus;
      if (loginStatus) {
        this.getUserDetails();
      }else {
        this.resetUser();
      }
    });
    // this.authService.userRole$.subscribe(urole => {
    //   this.role=urole;
    // });

    // this.getUserDetails();
  }

  getUserDetails(): void {

    this.user = this.authService.getUserDetails();
    if(this.user!==null){
      this.islogin=true;
    }
    if (this.user) {
      this.isRoleAdmin = this.user.role === 'ROLE_ADMIN';
      this.isNormalUser = this.user.role === 'ROLE_NORMAL';
    }
    console.log("role is",this.isRoleAdmin);
  }

  resetUser(): void {
    this.user = null;
    this.isRoleAdmin = false;
    this.isNormalUser = false;
  }


  logout(): void {
    // Optional logout functionality
    localStorage.removeItem('token');
    // this.islogin=false; 
    this.authService.updateLoginStatus(false);
    // Redirect or refresh the page after logout\
    this.router.navigate(['/signin']);
  }

}
