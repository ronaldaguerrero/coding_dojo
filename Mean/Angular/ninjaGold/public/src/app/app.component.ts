import { HttpService } from './http.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Ninja Gold - Angular style';
  gold = 0;
  log = [];

constructor(private _httpService: HttpService){}
   // ngOnInit will run when the component is initialized, after the constructor method.
   ngOnInit(){
    }
    random(min, max){
  		return (Math.floor(Math.random() * (min-max))+ max)
	  }

  	setGold(gold) {
    	this.gold += gold;
    	console.log('set gold ' + gold);
  	}

  	farm() {
  		// let observable = this._httpService.createGold();
  		// observable.subscribe(data => {
          	// console.log("Got our gold!", data)
    		let goldFound = this.random(2,6);
    		this.setGold(goldFound);
    		this.log.push('You earned ' + goldFound + ' gold at the farm');
    		console.log('farm ' + goldFound);
    		// this.gold = data['gold'];
    	// });
    }

    cave() {
    	let goldFound = this.random(5,11);
    	this.setGold(goldFound);
    	this.log.push('You earned ' + goldFound + ' gold at the cave');
    	console.log('cave ' + goldFound);
    }

    house() {
    	let goldFound = this.random(7,16);
    	this.setGold(goldFound);
    	this.log.push('You earned ' + goldFound + ' gold at the house');
    	console.log('house ' + goldFound);
    }

    casino() {
    	let goldFound = this.random(-100,100);
    	this.setGold(goldFound);
    	if (goldFound > 0){
		this.log.push('You earned ' + goldFound + ' gold at the casino');
    	} else {
 			this.log.push('You lost ' + (goldFound * -1) + ' gold at the casino');   		
    	}
    	console.log('casino ' + goldFound);
    }
}