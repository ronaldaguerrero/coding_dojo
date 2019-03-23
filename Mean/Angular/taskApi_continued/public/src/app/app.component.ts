import { HttpService } from './http.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
   // Set the attribute tasks to be an array.
   title = "Restful Tasks API";
   tasks = [];
   task = [];
   thisTask;
   constructor(private _httpService: HttpService){}
   // ngOnInit will run when the component is initialized, after the constructor method.
   ngOnInit(){
    }
    tasksOnClick(){
       let observable = this._httpService.getTasks();
       observable.subscribe(data => {
          console.log("Got our tasks!", data)
          // In this example, the array of tasks is assigned to the key 'tasks' in the data object. 
          // This may be different for you, depending on how you set up your Task API.
          this.tasks = data['tasks'];
       });
    }
    taskOnClick(id: any){
      let observable = this._httpService.getTask(id);
      observable.subscribe(data => {
          this.task = data['task'];
      });
    }
    taskToShow(x){
      console.log('taskToShow');
      this.thisTask = x;
      console.log(this.thisTask);
    }
}
