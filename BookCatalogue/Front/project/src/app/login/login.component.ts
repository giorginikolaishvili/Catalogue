import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Http} from '@angular/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userName = '';
  password: string;
  login: boolean;
  logout: boolean;

  constructor(private http: Http, private router: Router) {
  }

  headers = new HttpHeaders({'Content-type': 'application/json; charset=utf-8'});
  res = '';

  userloggingin() {
    var jsonstr = {'userName': this.userName, 'password': this.password};
    this.http.post('http://localhost:8080/api/postUser', jsonstr).subscribe(
      (data) => {
        var json = data.json();
        this.res = json.result;
        console.log(this.res);
        if (!(this.res === 'Invalid Username or Password')) {
          this.router.navigate(['/loggedIn']);
        }
        window.alert(this.res);
      },
      error => {
        console.error(error);
      }
    );
    return this.res;
  }

  ngOnInit() {
  }

}
