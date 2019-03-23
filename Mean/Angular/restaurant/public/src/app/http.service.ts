import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) {}
  createRestaurant(newRestaurant){
      // console.log('New from service');
      console.log(newRestaurant);
      return this._http.post('/restaurant', newRestaurant);
    }
  getRestaurants(){
      // Remove the lines of code where we make the variable 'tempObservable' and subscribe to it.copy
      // tempObservable = this._http.get('/tasks');
      // tempObservable.subscribe(data => console.log("Got our tasks!", data));
      // Return the observable to wherever the getTasks method was invoked.
      return this._http.get('/restaurants');
    }
  getRestaurant(id){
    return this._http.get('/restaurants/' + id);
    }
  deleteRestaurant(id){
    return this._http.delete('/' + id); 
  }
  editRestaurant(id, restaurant){
   return this._http.put('/restaurant/'+ id, restaurant); 
  }
}
