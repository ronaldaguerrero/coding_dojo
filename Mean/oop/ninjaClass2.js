function Ninja(name){
	var speed = 3;
	var strength = 3;
	this.name = name;
	this.health = 100;

	this.drinkSake = function(){
		this.health += 10;
	}

	this.showStats = function(){
		console.log("Name: " + this.name + ", Health: " + this.health + ", Speed: " + speed + ", Strength: " + strength);
		return this;
	}

	// this.punch = function(ninja){
	// 	if(!(ninja instanceof Ninja)){
	// 		console.log("Not a Ninja!");
	// 		return false;
	// 	}
	// 	ninja.health -= 5;
	// 	console.log(ninja.name + " was punched by " + this.name + " and lost 5 Health!");
	// }

	this.kick = function(ninja){
		if(!(ninja instanceof Ninja)){
			console.log("Not a Ninja!");
			return false;
		}
		var amt = (ninja.health -= (15 * strength));
		console.log(ninja.name + " was kicked by " + this.name + " and lost "+ amt +" health because " + this.name + " has " + strength + " points of strength.");
	}
}

Ninja.prototype.sayName = function(){
	console.log("My ninja name is " + this.name + "!");
}

Ninja.prototype.punch = function(ninja){
	if(!(ninja instanceof Ninja)){
		console.log("Not a Ninja!");
		return false;
	}
	ninja.health -= 5;
	console.log(ninja.name + " was punched by " + this.name + " and lost 5 Health!");
}

var ninja1 = new Ninja("Hyabusa");
var ninja2 = new Ninja("Tacoma");
var ninja3 = "Toyota"


// ninja1.showStats();

ninja1.punch(ninja2);

// ninja2.punch(ninja3);