import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CenterService {
  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }
  addCenter(centerDetails): Observable<any> {
      return this.http.post<any>(`${this.url}/addCenter`, centerDetails);
    }
    deleteCenter(center: Center): Observable<any> {
      return this.http.delete<any>(`${this.url}/deleteCenter/${center.centerId}`);

    }
    searchCenter(centerDetails): Observable<any> {
      return this.http.get<any>(`${this.url}/searchCenter`, centerDetails);
    }
    viewAllCenters(): Observable<any> {
      return this.http.get<any>(`${this.url}/viewAllCenters`);
    }
    updateCenter(center) {
      return this.http.put<any>(`${this.url}/updateCenter`, center);
    }

}
