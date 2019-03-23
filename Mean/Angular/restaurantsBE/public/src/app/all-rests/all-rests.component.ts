import { HttpService } from './../http.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-rests',
  templateUrl: './all-rests.component.html',
  styleUrls: ['./all-rests.component.css']
})
export class AllRestsComponent implements OnInit {
restaurants = [];

  constructor(private _httpService: HttpService){}

  ngOnInit() {
  	this.getRests();
  }

  getRests(){
       let observable = this._httpService.getRests();
       observable.subscribe(data => {
          this.restaurants = data['restaurants'];
          // console.log('component');
          // console.log(data);
       });
    }

    deleteRest(id: any){
      let observable = this._httpService.deleteRest(id);
      observable.subscribe(data => {
          this.getRests();
      });
    }
}
