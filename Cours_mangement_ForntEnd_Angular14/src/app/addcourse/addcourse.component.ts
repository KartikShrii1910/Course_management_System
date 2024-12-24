import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Courses } from '../models/coueses.model';
import { CourseServiceService } from '../services/course-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addcourse',
  templateUrl: './addcourse.component.html',
  styleUrl: './addcourse.component.css'
})
export class AddcourseComponent {

  courseForm!:FormGroup;
  courseModel:Courses=new Courses();

  constructor(private fb: FormBuilder,private courseservice:CourseServiceService){
    this.buildForm()
  }

  buildForm() {
    this.courseForm = this.fb.group({
      courseName: ['', [Validators.required, Validators.pattern('^[a-zA-Z ]+$')]],
      courseDescription: ['', [Validators.required, Validators.pattern('^[a-zA-Z ]+$')]],
      duration: ['', Validators.required],
      fees: ['', Validators.required],
      
    })
  }

  onSubmit():void{
    if(this.courseForm.valid){
      this.bindModel();
      this.savePersonalDetail();
    }
  }



  bindModel() {
    this.courseModel.courseName = this.courseForm.controls['courseName'].value;
    this.courseModel.courseDescription = this.courseForm.controls['courseDescription'].value;
    this.courseModel.duration = this.courseForm.controls['duration'].value;
    this.courseModel.fees = this.courseForm.controls['fees'].value;
  }

  savePersonalDetail() {
    this.courseservice.saveCourse(this.courseModel).subscribe({
      next: () => {
        Swal.fire({
          title: 'Success!',
          text: 'Form submitted successfully!',
          icon: 'success',
          confirmButtonText: 'OK'
        }).then(() => {
          this.courseForm.reset();  // Clear the form after submission
        });
      },
      error: (err) => {
        Swal.fire({
          title: 'Error!',
          text: 'There was an error while submitting the form.',
          icon: 'error',
          confirmButtonText: 'OK'
        });
        console.error('Error while submitting the form:', err);
      }
    })
  }
}
