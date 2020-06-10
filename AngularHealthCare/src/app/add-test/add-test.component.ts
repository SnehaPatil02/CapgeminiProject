import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css']
})
export class AddTestComponent implements OnInit {
  success: string;
  failure: string;

  constructor(private test: TestService) { }

  ngOnInit() { }
    addTest(form: NgForm) {
      this.test.addTest(form.value).subscribe(data => {
        console.log(data);


        if (data.statusCode === 201) {
          this.success = data.discription;
          setTimeout(() => {
            this.success = null;
          }, 2000);
          form.reset();
          } else {
            this.failure = data.discription;
            setTimeout(() => {
              this.failure = null;
            }, 2000);
        }
      });
  }

}
