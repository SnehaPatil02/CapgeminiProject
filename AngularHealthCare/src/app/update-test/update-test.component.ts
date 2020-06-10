import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-test',
  templateUrl: './update-test.component.html',
  styleUrls: ['./update-test.component.css']
})
export class UpdateTestComponent implements OnInit {
  testId1;
  testName1;
  centerId1;

  constructor(private testDetails: TestService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
activatedRoute.params.subscribe( data => {
console.log(data.testId);
this.testId1 = data.testId;
});
activatedRoute.queryParams.subscribe( data => {
  console.log(data);
  this.testName1 = data.testName;
  this.centerId1 = data.centerId;

});
}

  ngOnInit() {
  }
  updateTest(form: NgForm) {
    console.log(form.value);
    this.testDetails.updateTest(form.value).subscribe( data => {
      console.log(data);
      this.router.navigateByUrl('/view-all-tests');
    });
  }

}
