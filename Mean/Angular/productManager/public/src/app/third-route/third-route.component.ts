import { HttpService } from './../http.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';


@Component({
  selector: 'app-third-route',
  templateUrl: './third-route.component.html',
  styleUrls: ['./third-route.component.css']
})
export class ThirdRouteComponent implements OnInit {

  constructor(
  	private _httpService: HttpService, 
  	private _router: Router,
  	private _route: ActivatedRoute){}
  productInfo = {title: '', price: 0, img: ''}
  error = "";
  ngOnInit() {
  }
  createProduct(){
      // console.log('create');
      let observable = this._httpService.createProduct(this.productInfo);
      observable.subscribe((data:any) => {
        // console.log(data);
        if(data.message){
          console.log('error');
          this.error = data.message;
          this._router.navigate(["/third-route"]);
        } else{
          console.log('success');
          this._router.navigate(["/second-route"]);
        }
		// console.log("Task from component");
      });
    }
}
