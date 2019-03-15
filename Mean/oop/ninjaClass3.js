class Ninja {
	constructor(name){
		this.name = name;
		this.health = 100;
		this.speed = 3;
		this.strength = 3;
	}	
	sayName(){
		console.log(`${this.name}`);
	}
	showStats(){
		console.log(`Name: ${this.name}, Health: ${this.health}, Speed: ${this.speed}, Strength: ${this.strength}`);
	}
	drinkSake(){
		this.health += 10;
	}
}

class Sensai extends Ninja{
	constructor(name){
		super(name);
	}
	speakWisdom(){
		super.drinkSake();
		console.log(`What one programmer can do in one month, two programmers can do in two months`);	
	}
	// super.sayName();
	// super.showStats();
	
}

const ninja1 = new Ninja("Hyabusa");
const ninja2 = new Ninja("Tacoma");

// ninja1.drinkSake();
// ninja1.showStats();
// ninja1.sayName();

const s1 = new Sensai("Yoda");
s1.speakWisdom();
s1.showStats();