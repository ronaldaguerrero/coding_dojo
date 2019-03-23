import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) { 
  }
  getCakes(){
    // Remove the lines of code where we make the variable 'tempObservable' and subscribe to it.copy
    // tempObservable = this._http.get('/tasks');
    // tempObservable.subscribe(data => console.log("Got our tasks!", data));
    // Return the observable to wherever the getTasks method was invoked.
    return this._http.get('/cakes');
  }
  getCake(id){
   return this._http.get('/cake/'+id); 
  }
  getReviews(){
    return this._http.get('/reviews');
  }
  createCake(newCake){
    // console.log('New task from service');
    // console.log(newTask);
    return this._http.post('/cake', newCake);
  }
  createReview(id, newReview){
   return this._http.post('/review/' + id, newReview); 
  }
  deleteCake(id){
    return this._http.delete('/' + id); 
  }
  deleteReview(id){
    // console.log('Delete from service');
    return this._http.delete('/review/' + id); 
  }
  // getTasks(){
  //     // Remove the lines of code where we make the variable 'tempObservable' and subscribe to it.copy
  //     // tempObservable = this._http.get('/tasks');
  //     // tempObservable.subscribe(data => console.log("Got our tasks!", data));
  //     // Return the observable to wherever the getTasks method was invoked.
  //     return this._http.get('/tasks');
  //   }
  // getTask(taskId){
  //   return this._http.get('/tasks/' + taskId);
  //   }
}
