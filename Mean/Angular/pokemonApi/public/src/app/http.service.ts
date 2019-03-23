import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) { 
  	  // this.getTasks();
  	  this.getPokemon();
  	  this.pokemonAbilities();
  	  this.snore();
  	  this.shareBlaze();
  	  
  }

 //  getTasks(){
 //    // our http response is an Observable, store it in a variable
 //    let tempObservable = this._http.get('/tasks');
 //    // subscribe to the Observable and provide the code we would like to do with our data from the response
 //    tempObservable.subscribe(data => console.log("Got our tasks!", data));
 // }
getPokemon(){
    let charmander = this._http.get('https://pokeapi.co/api/v2/pokemon/charmander/');
   
    charmander.subscribe((data) => console.log("Got pokemon data: ", data));
	};

pokemonAbilities(){
	let pokemon = this._http.get("https://pokeapi.co/api/v2/pokemon/charmander/");
	pokemon.subscribe((data:any) => {
	  console.log(`${data.name}'s abilities are ${data.abilities[0].ability.name} and ${data.abilities[1].ability.name}.`);
		})
	};

snore(){
    let snore = this._http.get('https://pokeapi.co/api/v2/pokemon/charmander/');
    snore.subscribe((data:any) => console.log("This pokemon has a move called: ", data.moves[38].move.name));
	};

shareBlaze(){
	let shareBlaze = this._http.get('https://pokeapi.co/api/v2/ability/66/');
    shareBlaze.subscribe((data:any) => { 
    	console.log("# of pokemon that share the ability blaze:", data.pokemon.length);	
    	for(let i: number = 0; i < data.pokemon.length; i++){
    		console.log("These pokemon share the ability blaze:", data.pokemon[i].pokemon.name);	
   	 	}
    })
}
}
