import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CenterService } from '../center.service';

@Component({
  selector: 'app-add-center',
  templateUrl: './add-center.component.html',
  styleUrls: ['./add-center.component.css']
})
export class AddCenterComponent implements OnInit {
  success: string;
  failure: string;

  constructor(private center: CenterService) { }

  ngOnInit() { }
    addCenter(form: NgForm) {
      this.center.addCenter(form.value).subscribe(data => {
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
