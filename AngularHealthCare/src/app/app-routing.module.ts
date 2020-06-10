import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AdminComponent } from './admin/admin.component';
import { AddCenterComponent } from './add-center/add-center.component';
import { UpdateCenterComponent } from './update-center/update-center.component';
import { ViewAllCentersComponent } from './view-all-centers/view-all-centers.component';
import { AddTestComponent } from './add-test/add-test.component';
import { UpdateTestComponent } from './update-test/update-test.component';
import { ViewAllTestsComponent } from './view-all-tests/view-all-tests.component';
import { ViewAllAppointmentsComponent } from './view-all-appointments/view-all-appointments.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AboutComponent } from './about/about.component';
import { ApproveAppointmentComponent } from './approve-appointment/approve-appointment.component';


const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'header', component: HeaderComponent},
  { path: 'footer', component: FooterComponent},
  { path: 'about', component: AboutComponent},
  { path: 'admin', component: AdminComponent},
  { path: 'add-center', component: AddCenterComponent},
  { path: 'update-center/:centerId', component: UpdateCenterComponent},
  { path: 'view-all-centers', component: ViewAllCentersComponent},
  { path: 'add-test', component: AddTestComponent},
  { path: 'update-test/:testId', component: UpdateTestComponent},
  { path: 'view-all-tests', component: ViewAllTestsComponent},
  { path: 'view-all-appointments', component: ViewAllAppointmentsComponent},
  { path: 'approve-appointment/:appointmentId', component: ApproveAppointmentComponent},
  { path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
