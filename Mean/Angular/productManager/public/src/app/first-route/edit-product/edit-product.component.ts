import { HttpService } from './../../http.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {
eProduct = { title: "", price: 0, img: ""};
id;
product;
error = "";
  constructor(
  	private _httpService: HttpService, 
  	private _router: Router,
  	private _route: ActivatedRoute) {}

  ngOnInit() {
  	this._route.params.subscribe((params: Params) => {
        // console.log(params['id'])
        this.id = params['id'];
        this.getProduct(this.id);
    });
  }

  getProduct(id: any){
    	let observable = this._httpService.getProduct(id);
    	observable.subscribe(data => {
          this.product = data['product'];
          console.log(this.product);
          let title: string = this.product[0].title;
          let price: number = this.product[0].price;
          let img: string = this.product[0].img;
          this.eProduct.title = title;
          this.eProduct.price = price;
          this.eProduct.img = img;
    	});
    }

  editProduct(id: any){
      let observable = this._httpService.editProduct(id, this.eProduct);
      observable.subscribe((data:any) => {
      	if(data.message){
          console.log('error');
          this.error = data.message;
          this._router.navigate(["/second-route/edit/" + id]);
        } else{
          console.log('success');
          this._router.navigate(["/second-route"]);
        }
      });
    }
}
