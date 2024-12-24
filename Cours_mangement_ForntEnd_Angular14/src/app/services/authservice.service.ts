import { Injectable, Inject, PLATFORM_ID } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { isPlatformBrowser } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {

  private logStatus = new BehaviorSubject<boolean>(false);
  LoginStatus$ = this.logStatus.asObservable();
  
  private uRole = new BehaviorSubject<string>('');
  userRole$ = this.uRole.asObservable();

  constructor(@Inject(PLATFORM_ID) private platformId: Object) {
    if (isPlatformBrowser(this.platformId)) {
      const storedLogin = localStorage.getItem('isLogin');
      if (storedLogin) {
        this.logStatus.next(JSON.parse(storedLogin));
      }
    }
  }

  updateLoginStatus(loginStatus: boolean) {
    if (isPlatformBrowser(this.platformId)) {
      localStorage.setItem('isLogin', loginStatus.toString());
    }
    this.logStatus.next(loginStatus);
  }

  updateUserRole(userRole: string) {
    this.uRole.next(userRole);
  }

  getDecodedToken(): any {
    if (isPlatformBrowser(this.platformId)) {
      const token = localStorage.getItem('token');
      if (token) {
        const payload = token.split('.')[1];
        const decoded = atob(payload);
        return JSON.parse(decoded);
      }
    }
    return null;
  }

  getUserDetails(): any {
    const decodedToken = this.getDecodedToken();
    if (decodedToken && decodedToken.sub) {
      const userDetails = decodedToken.sub
        .replace(/{|}/g, '')  // Remove curly braces
        .split(', ')           // Split by comma
        .reduce((acc: any, pair: string) => {
          const [key, value] = pair.split('=');
          acc[key] = value;
          return acc;  
        }, {});
      
      return userDetails;
    }
    return null;
  }
  
}
