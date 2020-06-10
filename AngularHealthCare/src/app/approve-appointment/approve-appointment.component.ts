import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AppointmentService } from '../appointment.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-approve-appointment',
  templateUrl: './approve-appointment.component.html',
  styleUrls: ['./approve-appointment.component.css']
})
export class ApproveAppointmentComponent implements OnInit {
  appointmentId1;
  userId1;
  userName1;
  testName1;
  dateTime1;
  status1;

  constructor(private appointmentDetails: AppointmentService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
activatedRoute.params.subscribe( data => {
console.log(data.appointmentId);
this.appointmentId1 = data.appointmentId;
});
activatedRoute.queryParams.subscribe( data => {
  console.log(data);
  this.userId1 = data.userId;
  this.userName1 = data.userName;
  this.testName1 = data.testName;
  this.dateTime1 = data.dateTime;
  this.status1 = data.status;


});
}

  ngOnInit() {
  }
  approveAppointment(form: NgForm) {
    console.log(form.value);
    this.appointmentDetails.approveAppointment(form.value).subscribe( data => {
      console.log(data);
      this.router.navigateByUrl('/view-all-appointments');
    });
  }


}
