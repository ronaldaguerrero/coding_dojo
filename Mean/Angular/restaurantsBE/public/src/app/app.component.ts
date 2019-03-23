import { HttpService } from './http.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
   // Set the attribute tasks to be an array.
   title = "Let's eat";
   restaurants = [];
   reviews = [];
   restaurant;
   name;
   img;
   pair = {name: '', cuisine: ''};
   eRest = { name: "", cuisine:""};
   review = {name: '', cmt: '', rating: 0};
   avg;
   edit = false;
   constructor(private _httpService: HttpService){}
   // ngOnInit will run when the component is initialized, after the constructor method.
   ngOnInit(){
     this.pair = {name: '', cuisine: ''}
     this.allReviews();
    }

    info(idx){
      // console.log('info from component');
      this.restaurant = this.restaurants[idx];
      // console.log(this.restaurant);
      var sum = 0;
      for(var i = 0; i < this.restaurant.ratings.length; i++){
        sum += this.restaurant.ratings[i].rating;
      }
      this.avg = ((sum/this.restaurant.ratings.length).toFixed(1));
      // console.log('avg rating');
      // console.log(this.avg);
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

    
}
