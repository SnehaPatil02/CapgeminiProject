import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {


  constructor(private http: HttpClient) { }
  url = 'http://localhost:8080';


  loginAdmin(adminDetails): Observable<any> {
  return this.http.post<any>(`${this.url}/loginAdmin`, adminDetails);
}
}
