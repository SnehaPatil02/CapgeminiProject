import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }
    viewAllAppointments(): Observable<any> {
      return this.http.get<any>(`${this.url}/viewAllAppointments`);
   }
   approveAppointment(appointment) {
    return this.http.put<any>(`${this.url}/approveAppointment`, appointment);
  }

}
