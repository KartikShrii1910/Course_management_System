import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { RegistrationComponent } from './registration/registration.component';
import { UserdataComponent } from './userdata/userdata.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import { MatRadioModule } from '@angular/material/radio';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './navbar/navbar.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSelectModule } from '@angular/material/select';
import { ListofcoursesComponent } from './listofcourses/listofcourses.component';
import { ListofpurchsecourseComponent } from './listofpurchsecourse/listofpurchsecourse.component';
import { CoursespurchasebystudentComponent } from './coursespurchasebystudent/coursespurchasebystudent.component';
import { AddcourseComponent } from './addcourse/addcourse.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    UserdataComponent,
    LoginComponent,
    NavbarComponent,
    ListofcoursesComponent,
    ListofpurchsecourseComponent,
    CoursespurchasebystudentComponent,
    AddcourseComponent,
 

  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatInputModule,
    MatButtonModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatRadioModule,
    MatSnackBarModule,
    AppRoutingModule,
    MatSelectModule
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
