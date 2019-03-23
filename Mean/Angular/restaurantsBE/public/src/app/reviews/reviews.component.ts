import { HttpService } from './../http.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {
ratings;
restaurant;
id;

  constructor(
  	private _httpService: HttpService,
  	private _router: Router,
  	private _route: ActivatedRoute){}

  ngOnInit() {
  	this._route.params.subscribe((params: Params) => {
        // console.log(params['id'])
        this.id = params['id'];
        this.restToShow(this.id);
  	})
  }

	restToShow(id: any){
      // console.log('component show me');
      let observable = this._httpService.getRest(id);
       observable.subscribe(data => {
          this.restaurant = data['restaurant'];
          console.log(this.restaurant[0].ratings);
          this.ratings = this.restaurant[0].ratings;
       });
    }

}
