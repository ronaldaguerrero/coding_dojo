import { HttpService } from './../http.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';

@Component({
  selector: 'app-new-review',
  templateUrl: './new-review.component.html',
  styleUrls: ['./new-review.component.css']
})
export class NewReviewComponent implements OnInit {
id;
review = {name: '', cmt: '', rating: 5};
restaurant;
name;
error;
  constructor(
  	private _httpService: HttpService,
  	private _router: Router,
  	private _route: ActivatedRoute) { }

  ngOnInit() {
  	this._route.params.subscribe((params: Params) => {
        // console.log(params['id'])
        this.id = params['id'];
  	})
  	this.restToShow(this.id);
  }

  restToShow(id: any){
      // console.log('component show me');
      let observable = this._httpService.getRest(id);
       observable.subscribe(data => {
          this.restaurant = data['restaurant'];
          console.log('rest to show component');
          console.log(this.restaurant[0].name);
          let name: string = this.restaurant[0].name;
       });
    }

  createReview(id: any){
      let observable = this._httpService.createReview(id, this.review);
      observable.subscribe((data:any) => {
        console.log('this is the body message');
        console.log(data.message);
        if(data.message){
          console.log('error');
          this.error = data.message;
          this._router.navigate(["/restaurants", id, "review"]);
        } else{
          this._router.navigate(["/restaurants"]);
        }
      });
    }

}
