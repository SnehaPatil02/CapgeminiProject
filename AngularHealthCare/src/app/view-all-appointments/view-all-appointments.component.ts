import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-all-appointments',
  templateUrl: './view-all-appointments.component.html',
  styleUrls: ['./view-all-appointments.component.css']
})
export class ViewAllAppointmentsComponent implements OnInit {
  success: string;
  failure: string;
  appointment: Appointment[];

  constructor(private appointmentDetails: AppointmentService,
              private router: Router) {
              this.viewAllAppointments();
}

  viewAllAppointments() {
    this.appointmentDetails.viewAllAppointments().subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.appointment = response.beans;
        this.success = response.discription;
        localStorage.setItem('center Details', JSON.stringify(response));
        console.log('center Details are added');
        setTimeout(() => {
          this.success = null;
        }, 2000);
       } else {
          this.failure = response.discription;
          setTimeout(() => {
            this.failure = null;
          }, 2000);
      }
    });
  }
  approveAppointment(appointment) {
    console.log(appointment);
    this.router.navigate([`/approve-appoinment/${appointment.appointmentId}`],
    { queryParams: {
      userId : appointment.userId,
  userName : appointment.userName,
  testName : appointment.testName,
  dateTime : appointment.dateTime,
  status : appointment.status
    }});
  }
  ngOnInit() {
  }

}
