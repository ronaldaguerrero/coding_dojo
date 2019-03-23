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
   id;
   newTask = {title: "", desc: "" };
   eTask;

   constructor(private _httpService: HttpService){}
   // ngOnInit will run when the component is initialized, after the constructor method.
   ngOnInit(){
    this.newTask = { title: "", desc: "" };
    this.eTask = { title: "", desc: "" };
    this.allTasks();
    }
    allTasks(){
       let observable = this._httpService.getTasks();
       observable.subscribe(data => {
          // console.log("Got our tasks!", data)
          // In this example, the array of tasks is assigned to the key 'tasks' in the data object. 
          // This may be different for you, depending on how you set up your Task API.
          this.tasks = data['tasks'];
       });
    }
    taskOnClick(id: any){
    	let observable = this._httpService.getTask(id);
    	observable.subscribe(data => {
          this.task = data['task'];
          // console.log(this.eTask);
          let title: string = this.task[0].title;
          let desc: string = this.task[0].desc;
          this.eTask.title = title;
          this.eTask.desc = desc;
    	});
    }
    createTask(){
      let observable = this._httpService.createTask(this.newTask);
      observable.subscribe(data => {
        // console.log("Task from component");
        // console.log(this.newTask);
        this.allTasks();
      });
    }
    editTask(id: any){
      let observable = this._httpService.editTask(id, this.eTask);
      observable.subscribe(data => {
        console.log("Edit from component");
        this.allTasks();
      });
    }
    deleteTask(id: any){
      let observable = this._httpService.deleteTask(id);
      observable.subscribe(data => {
          // console.log("Delete from component");
          this.allTasks();
      });
    }

}
