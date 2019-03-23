import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HttpService {
  id;

  constructor(private _http: HttpClient) { 
  	  // this.getTasks();
  	  // this.getTasks();
  }
  getTasks(){
    // Remove the lines of code where we make the variable 'tempObservable' and subscribe to it.copy
    // tempObservable = this._http.get('/tasks');
    // tempObservable.subscribe(data => console.log("Got our tasks!", data));
    // Return the observable to wherever the getTasks method was invoked.
    return this._http.get('/tasks');
  }
  getTask(taskId){
    return this._http.get('/tasks/' + taskId);
  }
  createTask(newTask){
    // console.log('New task from service');
    // console.log(newTask);
    return this._http.post('/tasks', newTask);
  }
  editTask(taskId, task){
   return this._http.put('/tasks/'+ taskId, task); 
  }
  deleteTask(taskId){
    // console.log('Delete from service');
    return this._http.delete('/' + taskId); 
  }

}
