import { HttpService } from './http.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
   // Set the attribute tasks to be an array.
   title = "PPM - Project Product Management";
   products = [];
   product = [];
   constructor(private _httpService: HttpService){}
   // ngOnInit will run when the component is initialized, after the constructor method.
   ngOnInit(){
    }    
    productsOnClick(){
       let observable = this._httpService.getProducts();
       observable.subscribe(data => {
          console.log("Got our tasks!", data)
          // In this example, the array of tasks is assigned to the key 'tasks' in the data object. 
          // This may be different for you, depending on how you set up your Task API.
          this.products = data['products'];
       });
    }
    productOnClick(id: any){
      let observable = this._httpService.getProduct(id);
      observable.subscribe(data => {
          this.product = data['product'];
      });
    }
}
