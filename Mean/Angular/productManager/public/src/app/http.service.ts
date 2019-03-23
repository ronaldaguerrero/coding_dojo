import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) {}
  createProduct(newProduct){
      console.log('New task from service');
      console.log(newProduct);
      return this._http.post('/product', newProduct);
    }
  getProducts(){
      // Remove the lines of code where we make the variable 'tempObservable' and subscribe to it.copy
      // tempObservable = this._http.get('/tasks');
      // tempObservable.subscribe(data => console.log("Got our tasks!", data));
      // Return the observable to wherever the getTasks method was invoked.
      return this._http.get('/products');
    }
  getProduct(id){
    return this._http.get('/products/' + id);
    }
  deleteProduct(id){
    return this._http.delete('/' + id); 
  }
  editProduct(id, product){
   return this._http.put('/product/'+ id, product); 
  }
}
