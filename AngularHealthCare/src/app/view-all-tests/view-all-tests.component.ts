import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TestService } from '../test.service';

@Component({
  selector: 'app-view-all-tests',
  templateUrl: './view-all-tests.component.html',
  styleUrls: ['./view-all-tests.component.css']
})
export class ViewAllTestsComponent implements OnInit {
  success: string;
  failure: string;
  tests: Test[];
  constructor(private testDetails: TestService,
              private router: Router) {
this.viewAllTests();
}

deleteTest(test: Test) {
  this.testDetails.deleteTest(test).subscribe(data => {
    console.log(data);
    if (data.statusCode === 201) {
      this.tests.splice(this.tests.indexOf(test), 1);
      this.success = data.message;
      setTimeout(() => {
        this.success = null;
      }, 2000);
    }
  });
}

viewAllTests() {
  this.testDetails.viewAllTests().subscribe(response => {
    console.log(response);
    if (response.statusCode === 201) {
      this.tests = response.beans;
      this.success = response.discription;
      localStorage.setItem('test Details', JSON.stringify(response));
      console.log('test Details are added');
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

updateTest(test) {
  //console.log(test);
  this.router.navigate([`/update-test/${test.testId}`],
  { queryParams: {
    testName: test.testName,
    centerId: test.centerId
  }});
}

  ngOnInit() {
  }

}
