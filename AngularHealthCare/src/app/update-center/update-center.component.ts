import { Component, OnInit } from '@angular/core';
import { CenterService } from '../center.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-center',
  templateUrl: './update-center.component.html',
  styleUrls: ['./update-center.component.css']
})
export class UpdateCenterComponent implements OnInit {
  centerId1;
  centerName1;

  constructor(private centerDetails: CenterService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
activatedRoute.params.subscribe( data => {
console.log(data.centerId);
this.centerId1 = data.centerId;
});
activatedRoute.queryParams.subscribe( data => {
  console.log(data);
  this.centerName1 = data.centerName;

});
}

  ngOnInit() {
  }
  updateCenter(form: NgForm) {
    console.log(form.value);
    this.centerDetails.updateCenter(form.value).subscribe( data => {
      console.log(data);
      this.router.navigateByUrl('/view-all-centers');
    });
  }

}
