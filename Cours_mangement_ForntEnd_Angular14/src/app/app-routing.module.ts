import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { UserdataComponent } from './userdata/userdata.component';
// import { AddcoursesComponent } from './addcourses/addcourses.component';
import { ListofcoursesComponent } from './listofcourses/listofcourses.component';
import { ListofpurchsecourseComponent } from './listofpurchsecourse/listofpurchsecourse.component';
import { CoursespurchasebystudentComponent } from './coursespurchasebystudent/coursespurchasebystudent.component';
import { AddcourseComponent } from './addcourse/addcourse.component';

const routes: Routes = [
  { path: 'signin', component: LoginComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'studentdetails', component: UserdataComponent },
  { path: 'addcourse', component: AddcourseComponent },
  { path: 'listofcourses', component: ListofcoursesComponent },
  { path: 'listofpurchasecourses', component: ListofpurchsecourseComponent },
  { path: 'coursespurchasebystudent', component: CoursespurchasebystudentComponent },
  { path: 'listofstudents', component: UserdataComponent },
  { path: '', redirectTo: 'signin', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
