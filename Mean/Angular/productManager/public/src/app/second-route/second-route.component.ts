import { HttpService } from './../http.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';


@Component({
  selector: 'app-second-route',
  templateUrl: './second-route.component.html',
  styleUrls: ['./second-route.component.css']
})
export class SecondRouteComponent implements OnInit {
	products = [];
   	product = [];
   	eProduct = { title: "", price: 0, url: ""};
	constructor(
	  	private _httpService: HttpService, 
	  	private _router: Router,
	  	private _route: ActivatedRoute){}
  	ngOnInit() {
  		// this._route.parent.params.subscribe(params => console.log(`The parent params: ${params}`))
  		this.getProducts();
  	}
  	getProducts(){
	    let observable = this._httpService.getProducts();
	    observable.subscribe(data => {
	      // console.log("Got our tasks!", data)
	      this.products = data['products'];
	   });
	}
	deleteProduct(id: any){
      let observable = this._httpService.deleteProduct(id);
      observable.subscribe(data => {
        // console.log("Delete from component");
  		this.getProducts();
      });
    }
}
