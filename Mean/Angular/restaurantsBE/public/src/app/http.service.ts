import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) { 
  }
  getRests(){
    return this._http.get('/restaurants');
  }
  getRest(id){
   return this._http.get('/restaurant/'+id); 
  }
  getReviews(){
    return this._http.get('/reviews');
  }
  createRest(newR){
    console.log('New task from service');
    console.log(newR);
    return this._http.post('/restaurant', newR);
  }
  createReview(id, newReview){
   console.log('server service');
   return this._http.post('/review/' + id, newReview); 
  }
  deleteRest(id){
    return this._http.delete('/' + id); 
  }
  deleteReview(id){
    // console.log('Delete from service');
    return this._http.delete('/review/' + id); 
  }
  editRest(id, editR){
   return this._http.put('/restaurant/'+ id, editR); 
  }
}
