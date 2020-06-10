import { Component, OnInit } from '@angular/core';
import { CenterService } from '../center.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-all-centers',
  templateUrl: './view-all-centers.component.html',
  styleUrls: ['./view-all-centers.component.css']
})
export class ViewAllCentersComponent implements OnInit {
  success: string;
  failure: string;
  centers: Center[];

  constructor(private centerDetails: CenterService,
              private router: Router) {
              this.viewAllCenters();
}

deleteCenter(center: Center) {
  this.centerDetails.deleteCenter(center).subscribe(data => {
    console.log(data);
    if (data.statusCode === 201) {
      this.centers.splice(this.centers.indexOf(center), 1);
      this.success = data.message;
      setTimeout(() => {
        this.success = null;
      }, 2000);
    }
  });
}

viewAllCenters() {
  this.centerDetails.viewAllCenters().subscribe(response => {
    console.log(response);
    if (response.statusCode === 201) {
      this.centers = response.beans;
      this.success = response.discription;
      localStorage.setItem('center Details', JSON.stringify(response));
      console.log('center Details are added');
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

updateCenter(center) {
  console.log(center);
  this.router.navigate([`/updateCenter/${center.centerId}`],
  { queryParams: {
    centerName: center.centerName
  }});
}

  ngOnInit() {
  }

}
