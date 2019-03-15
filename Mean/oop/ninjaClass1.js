function Ninja(name){
	var speed = 3;
	var strength =3 ;
	this.name = name;
	this.health = 100;

	this.drinkSake = function(){
		this.health += 10;
	}

	this.showStats = function(){
		console.log("Name: " + this.name + ", Health: " + this.health + ", Speed: " + speed + ", Strength: " + strength);
		return this;
	}
}

Ninja.prototype.sayName = function(){
	console.log("My ninja name is " + this.name + "!");
}

var ninja1 = new Ninja("Hyabusa");

ninja1.sayName();
ninja1.showStats();
ninja1.drinkSake();
ninja1.showStats();

var ninja2 = new Ninja("Tacoma");
ninja2.showStats();