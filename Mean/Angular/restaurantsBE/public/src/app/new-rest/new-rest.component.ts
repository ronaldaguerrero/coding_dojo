import { HttpService } from './../http.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';

@Component({
  selector: 'app-new-rest',
  templateUrl: './new-rest.component.html',
  styleUrls: ['./new-rest.component.css']
})
export class NewRestComponent implements OnInit {
restaurants = [];
pair = {name: '', cuisine: ''};
error;

  constructor(
  	private _httpService: HttpService,
  	private _router: Router,
  	private _route: ActivatedRoute){}

  ngOnInit() {
  }

  createRest(){
      // console.log('create');
      let observable = this._httpService.createRest(this.pair);
      observable.subscribe((data:any) => {
        if(data.message){
          console.log('error');
          this.error = data.message;
          this._router.navigate(["/restaurants/new/"]);
        } else{
          console.log('success');
          this._router.navigate(["/restaurants"]);
        }
      });
    }
}
