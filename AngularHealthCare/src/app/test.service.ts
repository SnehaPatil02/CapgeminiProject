import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TestService {
  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  addTest(testDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/addTest`, testDetails);
  }
  deleteTest(test: Test): Observable<any> {
    return this.http.delete<any>(`${this.url}/deleteTest/${test.testId}`);

  }
  searchTest(testDetails): Observable<any> {
    return this.http.get<any>(`${this.url}/searchTest`, testDetails);
  }
  viewAllTests(): Observable<any> {
    return this.http.get<any>(`${this.url}/viewAllTests`);
  }
  updateTest(test) {
    return this.http.put<any>(`${this.url}/modifyTest`, test);
  }


}
