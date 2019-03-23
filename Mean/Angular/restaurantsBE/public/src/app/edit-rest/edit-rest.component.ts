import { HttpService } from './../http.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';

@Component({
  selector: 'app-edit-rest',
  templateUrl: './edit-rest.component.html',
  styleUrls: ['./edit-rest.component.css']
})
export class EditRestComponent implements OnInit {
edit;
restaurant;
eRest = { name: "", cuisine:""};
id;
error;

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
          let name: string = this.restaurant[0].name;
          let cuisine: string = this.restaurant[0].cuisine;
          this.eRest.name = name;
          this.eRest.cuisine = cuisine;
       });
    }

    editRest(id: any){
      let observable = this._httpService.editRest(id, this.eRest);
      observable.subscribe((data:any) => {
        if(data.message){
          console.log('error');
          this.error = data.message;
          this._router.navigate(["/restaurants", id, "edit"]);
        } else{
          console.log('success');
          this._router.navigate(["/restaurants"]);
        }
      });
    }

}
