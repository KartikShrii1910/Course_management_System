// api.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class ApiService {
    private apiUrl = 'http://localhost:9090/studentdetails/new'; // Replace with your backend API URL

    constructor(private http: HttpClient) {}

    registerUser(userData: any) {
        return this.http.post<any>(this.apiUrl, userData);
    }
}
