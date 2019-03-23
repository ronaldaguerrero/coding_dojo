import { HttpService } from './http.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
   // Set the attribute tasks to be an array.
   title = "Rate my cakes";
   cakes = [];
   reviews = [];
   cake;
   baker;
   img;
   pair = {baker: '', img: ''}
   review = {cmt: '', rating: 0}
   avg;
   constructor(private _httpService: HttpService){}
   // ngOnInit will run when the component is initialized, after the constructor method.
   ngOnInit(){
     this.pair = {baker: '', img: ''}
     this.allCakes();
     this.allReviews();
    }
    createCake(){
      // console.log('create');
      let observable = this._httpService.createCake(this.pair);
      observable.subscribe(data => {
        // console.log("Task from component");
        // console.log(this.newTask);
        this.cakes.push(this.pair);
        this.allCakes();
      });
    }
    createReview(id: any){
      let observable = this._httpService.createReview(id, this.review);
      observable.subscribe(data => {
        // console.log(this.review);
        this.allReviews();
      });
    }
    allCakes(){
       let observable = this._httpService.getCakes();
       observable.subscribe(data => {
          this.cakes = data['cakes'];
          // console.log('component');
          // console.log(data);
       });
    }
    cakeToShow(id: any){
      // console.log('cake me');
      let observable = this._httpService.getCake(id);
       observable.subscribe(data => {
          this.cake = data['cake'];
       });
    }

    info(idx){
      console.log('info from component');
      this.cake = this.cakes[idx];
      console.log('this cake');
      console.log(this.cake);
      var sum = 0;
      for(var i = 0; i < this.cake.ratings.length; i++){
        sum += this.cake.ratings[i].rating;
      }
      this.avg = ((sum/this.cake.ratings.length).toFixed(1));
      console.log('avg rating');
      console.log(this.avg);
    }

    deleteCake(id: any){
      let observable = this._httpService.deleteCake(id);
      observable.subscribe(data => {
          // console.log("Delete from component");
          this.allCakes();
      });
    }
    deleteReview(id: any){
      // console.log("Delete from component");
      let observable = this._httpService.deleteReview(id);
      observable.subscribe(data => {
          // console.log("Delete from component");
          this.allReviews();
      });
    }

    allReviews(){
       let observable = this._httpService.getReviews();
       observable.subscribe(data => {
          this.reviews = data['reviews'];
       });
    }
    // tasksOnClick(){
    //    let observable = this._httpService.getTasks();
    //    observable.subscribe(data => {
    //       console.log("Got our tasks!", data)
    //       // In this example, the array of tasks is assigned to the key 'tasks' in the data object. 
    //       // This may be different for you, depending on how you set up your Task API.
    //       this.tasks = data['tasks'];
    //    });
    // }
    // taskOnClick(id: any){
    //   let observable = this._httpService.getTask(id);
    //   observable.subscribe(data => {
    //       this.task = data['task'];
    //   });
    // }
    // taskToShow(x){
    //   console.log('taskToShow');
    //   this.thisTask = x;
    //   console.log(this.thisTask);
    // }
}
