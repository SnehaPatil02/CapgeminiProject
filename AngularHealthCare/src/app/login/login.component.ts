import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  success: string;
  failure: string;

  constructor(private admin: AuthenticationService,
              private router: Router) { }

  loginAdmin(form: NgForm) {
    this.admin.loginAdmin(form.value).subscribe(data => {
      console.log(data);

      if (data.statusCode === 201) {
        this.success = data.discription;
        localStorage.setItem('userDetails', JSON.stringify(data));
        console.log('user Details stored in localStorage');
        this.router.navigateByUrl('/');


      } else {
        this.failure = data.discription;
        console.log('user Details stored in localStorage');
        setTimeout(() => {
          this.success = null;
        }, 3000);
      }
    });
  }
  ngOnInit() {
  }

}
