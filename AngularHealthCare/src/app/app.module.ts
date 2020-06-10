import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AboutComponent } from './about/about.component';
import { AddCenterComponent } from './add-center/add-center.component';
import { AddTestComponent } from './add-test/add-test.component';
import { ViewAllCentersComponent } from './view-all-centers/view-all-centers.component';
import { ViewAllTestsComponent } from './view-all-tests/view-all-tests.component';
import { UpdateCenterComponent } from './update-center/update-center.component';
import { UpdateTestComponent } from './update-test/update-test.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ViewAllAppointmentsComponent } from './view-all-appointments/view-all-appointments.component';
import { FilterCenterPipe } from './filter-center.pipe';
import { FilterTestPipe } from './filter-test.pipe';
import { ApproveAppointmentComponent } from './approve-appointment/approve-appointment.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    AboutComponent,
    AddCenterComponent,
    AddTestComponent,
    ViewAllCentersComponent,
    ViewAllTestsComponent,
    UpdateCenterComponent,
    UpdateTestComponent,
    PageNotFoundComponent,
    ViewAllAppointmentsComponent,
    FilterCenterPipe,
    FilterTestPipe,
    ApproveAppointmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
