import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Courses } from '../models/coueses.model';

@Injectable({
  providedIn: 'root'
})
export class CourseServiceService {


  
  constructor(private http: HttpClient) { }
  
  saveCourse(courseData: Courses) {
    let apiUrl = 'http://localhost:9090/course/new'; // Replace with your backend API URL

    return this.http.post<any>(apiUrl, courseData);
  }
}
