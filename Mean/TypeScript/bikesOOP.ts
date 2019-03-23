class Bike {
    miles: number;
    constructor(public price: number, public maxSpeed: string) {
        this.miles = 0;
    }
    displayInfo(){
        console.log("Price: " + this.price + ", Max Speed: " + this.maxSpeed + ", Total Miles: " + this.miles)
    }

    ride(){
        console.log("Riding");
        this.miles += 10;
        return this;
    }

    reverse(){
        console.log("Reversing");
        if (this.miles <= 5) {
            this.miles = 0;
            return this;
        }
        else{
            this.miles -= 5;
            return this;
        }
    }
}

var bike1 = new Bike(300, "10mph");
var bike2 = new Bike(200, "20mph");
var bike3 = new Bike(100, "30mph");


console.log("Bike 1");
bike1.ride().ride().ride().reverse();
bike1.displayInfo();

console.log("Bike 2");
bike2.ride().ride().reverse().reverse();
bike2.displayInfo();

console.log("Bike 3");
bike3.reverse().reverse().reverse();
bike3.displayInfo();