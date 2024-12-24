// registration.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, FormGroupDirective, NgForm } from '@angular/forms';
import { ApiService } from './registration.service';
import { ErrorStateMatcher } from '@angular/material/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

// import { MatDatepickerFilter } from '@angular/material/datepicker';

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {

  registrationForm = new FormGroup({
    fullName: new FormControl(''),
    gender: new FormControl(''),
    dateOfBirth: new FormControl(''),
    // age: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    qualification: new FormControl(''),
    role: new FormControl('ROLE_NORMAL'),
    address: new FormControl(''),
    mobileNumber: new FormControl(''),

  });
  hidePassword: boolean = true;

  togglePasswordVisibility(): void {
    this.hidePassword = !this.hidePassword;
  }





  matcher = new MyErrorStateMatcher();

  // age: number | null = null;

  constructor(private formBuilder: FormBuilder, private apiService: ApiService, private router: Router) { }

  ngOnInit() {
    this.registrationForm = this.formBuilder.group({
      fullName: ['', Validators.required],
      gender: ['', Validators.required],
      dateOfBirth: ['', Validators.required],
      // age: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      qualification: ['', Validators.required],
      role: ['ROLE_NORMAL'],
      address: ['', Validators.required],
      mobileNumber: ['', Validators.pattern('^((\\+91-?)|0)?[0-9]{10}$')],// Assuming Indian phone number format
    });
  }
  onSubmit() {
    if (this.registrationForm.valid) {
      const formData = this.registrationForm.value;
  
      // Display confirmation dialog
      Swal.fire({
        title: 'Confirm Registration',
        html: `
          <p><strong>Full Name:</strong> ${formData.fullName}</p>
          <p><strong>Gender:</strong> ${formData.gender}</p>
          <p><strong>Date of Birth:</strong> ${formData.dateOfBirth}</p>
          <p><strong>Email:</strong> ${formData.email}</p>
          <p><strong>Password:</strong> ${formData.password}</p>
          <p><strong>Qualification:</strong> ${formData.qualification}</p>
          <p><strong>Address:</strong> ${formData.address}</p>
          <p><strong>Mobile Number:</strong> ${formData.mobileNumber}</p>
        `,
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Register',
        cancelButtonText: 'Cancel'
      }).then((result) => {
        if (result.isConfirmed) {
          // Save data only upon confirmation
          this.apiService.registerUser(formData).subscribe(
            () => {
              console.log('User registered successfully');
              Swal.fire('Success', 'You have been successfully registered!', 'success');
              // Reset form after successful registration
              this.registrationForm.reset();
              this.router.navigate(['/signin']);
            },
            (error) => {
              console.error('Error occurred while registering user:', error);
              Swal.fire('Error', 'Registration failed. Please try again.', 'error');
            }
          );
        }
      });
    }
  }
  
  
  // onSubmit() {
  //   const formData = this.registrationForm.value;

  //   if (this.registrationForm.valid) {
  //     this.apiService.registerUser(this.registrationForm.value).subscribe(
  //       (response) => {
  //         Swal.fire({
  //           title: 'Confirm Registration',
  //           html: `
  //               <p><strong>Full Name:</strong> ${formData.fullName}</p>
  //               <p><strong>Email:</strong> ${formData.email}</p>
  //               <p><strong>Password:</strong> ${formData.password}</p>
  //               <p><strong>Qualification:</strong> ${formData.qualification}</p>
  //               <p><strong>Address:</strong> ${formData.address}</p>
  //               <p><strong>Mobile Number:</strong> ${formData.mobileNumber}</p>
  //           `,
  //           icon: 'question',
  //           showCancelButton: true,
  //           confirmButtonText: 'Register',
  //           cancelButtonText: 'Cancel'
  //       }).then((result) => {
  //           if (result.isConfirmed) {
  //               // Perform registration here
  //               // Display success message
  //               Swal.fire('Success', 'You have been successfully registered!', 'success');
  //           }
  //       });
  //         console.log('User registered successfully:', response);
  //         // Reset form after successful registration
  //         this.registrationForm.reset();
  //         alert('Registration successful!');
  //         this.router.navigate(['/signin']);
  //       },
  //       (error) => {
  //         console.error('Error occurred while registering user:', error);
  //         alert('Registration failed. Please try again.');
  //       }
  //     );
  //   }
  // }
//  selectedDate: Date = new Date(); // Initialize with today's date
//   age=1 ;

  // calculateAge(): void {
  //   const currentDate = new Date();
  //   const birthDate = new Date(this.selectedDate);
    
  //   let age = currentDate.getFullYear() - birthDate.getFullYear();
  //   const monthDiff = currentDate.getMonth() - birthDate.getMonth();
    
  //   if (monthDiff < 0 || (monthDiff === 0 && currentDate.getDate() < birthDate.getDate())) {
  //     age--;
  //   }

  //   this.age = age;
  // }

}