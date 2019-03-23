// 1. Setting Types - original
var myString: string;
// I can assign myString like this:
myString = "Bee stinger";
// Why is there a problem with this? What can I do to fix this?
myString = 9;

// refactored:
var myString: any; // changed type to any
myString = "Bee stinger";
myString = 9;

// 2. Setting the types for function parameters - original
function sayHello(name: string){
   return `Hello, ${name}!`;
}
// This is working great:
console.log(sayHello("Kermit"));
// Why isn't this working? I want it to return "Hello, 9!"
console.log(sayHello(9));

// refactored:
function sayHello(name: any){ // changed type to any
   return `Hello, ${name}!`;
}
console.log(sayHello("Kermit"));
console.log(sayHello(9));


// 3. Optional parameters
function fullName(firstName: string, lastName: string, middleName: string){
   let fullName = `${firstName} ${middleName} ${lastName}`;
   return fullName;
}
// This works:
console.log(fullName("Mary", "Moore", "Tyler"));
// What do I do if someone doesn't have a middle name?
console.log(fullName("Jimbo", "Jones"));


// refactored:
function fullName(firstName: string, lastName: string, middleName?: string){ //added ? to make middle name optional
   let fullName = `${firstName} ${middleName} ${lastName}`;
   return fullName;
}
console.log(fullName("Mary", "Moore", "Tyler"));
console.log(fullName("Jimbo", "Jones"));

// 4. Interfaces and function parameters
interface Student {
   firstName: string;
   lastName: string;
   belts: number;
}
function graduate(ninja: Student){
   return `Congratulations, ${ninja.firstName} ${ninja.lastName}, you earned ${ninja.belts} belts!`;
}
const christine = {
   firstName: "Christine",
   lastName: "Yang",
   belts: 2
}
const jay = {
   firstName: "Jay",
   lastName: "Patel",
   belt: 4
}
// This seems to work fine:
console.log(graduate(christine));
// This one has problems:
console.log(graduate(jay));

// refactored:
interface Student {
   firstName: string;
   lastName: string;
   belts: number;
}
function graduate(ninja: Student){
   return `Congratulations, ${ninja.firstName} ${ninja.lastName}, you earned ${ninja.belts} belts!`;
}
const christine = {
   firstName: "Christine",
   lastName: "Yang",
   belts: 2
}
const jay = {
   firstName: "Jay",
   lastName: "Patel",
   belts: 4 // added s to belt
}
console.log(graduate(christine));
console.log(graduate(jay));

// 5. Classes & function parameters
class Ninja {
   fullName: string;
   constructor(
      public firstName: string,
      public lastName: string){
         this.fullName = `${firstName} ${lastName}`;
      }
   debug(){
      console.log("Console.log() is my friend.")
   }
}
// This is not making an instance of Ninja, for some reason:copy
const shane = Ninja();
// Since I'm having trouble making an instance of Ninja, I decided to do this:
const turing = {
   fullName: "Alan Turing",
   firstName: "Alan",
   lastName: "Turing"
}
// Now I'll make a study function, which is a lot like our graduate function from above:
function study(programmer: Ninja){
   return `Ready to whiteboard an algorithm, ${programmer.fullName}?`
}
// Now this has problems:
console.log(study(turing));

// refactored:
class Ninja {
    fullName: string;
    constructor(
       public firstName: string,
       public lastName: string){
          this.fullName = `${firstName} ${lastName}`;
       }
    debug(){
       console.log("Console.log() is my friend.")
    }
 }
 const shane = new Ninja("Alan", "Turing") // added new to constructor and changed input parameters

 const turing = {
    fullName: "Alan Turing",
    firstName: "Alan",
    lastName: "Turing"
 }
 function study(programmer: Ninja){
    return `Ready to whiteboard an algorithm, ${programmer.fullName}?`
 }
 console.log(study(shane)); // changed input to a Ninja 

 // 6. Arrow functions:
 var increment = x => x + 1;
// This works great:
console.log(increment(3));
var square = x => {x * x};
// This is not showing me what I want:
console.log(square(4));
// This is not working:
var multiply = x,y => x * y;
// Nor is this working:
var math = (x, y) => let sum = x + y;
   let product = x * y;
   let difference = Math.abs(x-y);
   return [sum, product, difference];

// refactored
var increment = (x) => x + 1;
console.log(increment(3));
var square = (x) => x * x;
console.log(square(4));
var multiply = (x,y) => x * y;  // added parenthesis to accept input params
var math = (x, y) => {  // removed 'let sum =''
   let sum = x + y; // declared sum in function
   let product = x * y;
   let difference = Math.abs(x-y);
   return [sum, product, difference];
}

// 7. Arrow functions and 'this'
class Elephant {
   constructor(public age: number){}
   birthday = function(){
      this.age++;
   }
}
const babar = new Elephant(8);
setTimeout(babar.birthday, 1000)
setTimeout(function(){
   console.log(`Babar's age is ${babar.age}.`)
   }, 2000)
// Why didn't babar's age change? Fix this by using an arrow function in the Elephant class.


// refactored
class Elephant {
    constructor(public age: number){}
    birthday = () => function(){
       this.age++;
    }
 }
 const babar = new Elephant(8);
 setTimeout(babar.birthday(), 1000)
 setTimeout(function(){
    console.log(`Babar's age is ${babar.age}.`)
    }, 2000)