 //1 Rewrite the given code as it is seen by the interpreter
 //2 Predict the outputs
 //3 Run the original code and compare the outputs to your predictions

//#1 Given
console.log(hello);                                   
var hello = 'world';  

// After
console.log(hello); // undefined
hello = 'world';

//#2 Given
var needle = 'haystack';
test();
function test(){
	var needle = 'magnet';
	console.log(needle);
}

// After
needle = 'haystack';
test(); // test is invoked by searching global scope
function test(){
	console.log(needle); 
	needle = 'magnet'; // needle is assigned 'magnet'
	console.log(needle); // prints 'magnet'
}

//#3 Given
var brendan = 'super cool';
function print(){
	brendan = 'only okay';
	console.log(brendan);
}
console.log(brendan);

// After
brendan = 'super cool'; // brendan is assigned 'super cool'
function print(){
	brendan = 'only okay'; // brendan doesn't exist
	console.log(brendan); // prints nothing
}
console.log(brendan); // prints super cool

//#4 Given
var food = 'chicken';
console.log(food);
eat();
function eat(){
	food = 'half-chicken';
	console.log(food);
	var food = 'gone';
}

// After
food = 'chicken'; // food is assigned 'chicken'
console.log(food); // prints 'chicken'
eat(); // invokes eat by searching global scope
function eat(){
	food = 'half-chicken'; // searching function's scope and assigns food 'half-chicken'
	console.log(food); // searching function's scope for food and prints gone
	food = 'gone'; // food is assigned gone
}

//#5 Given
mean();
console.log(food);
var mean = function() {
	food = "chicken";
	console.log(food);
	var food = "fish";
	console.log(food);
}
mean();

// After
mean(); // invokes mean and results in error because it is being invoked before function is created
console.log(food); // food is not defined
mean = function() { // assign mean function
	food = "chicken"; // searching function's scope for food and assigns food 'chicken'
	console.log(food); // searching function's scope for food and prints 'chicken'
	food = "fish"; // assigns food, 'fish'
	console.log(food); // searching function's scope for fod and prints 'fish'
}

//#6 Given
console.log(genre); 
var genre = "disco";
rewind();
function rewind() {
	genre = "rock";
	console.log(genre);
	var genre = "r&b";
	console.log(genre);
}
console.log(genre);

// After
console.log(genre); // genre is not defined
genre = "disco"; // assigns 'disco' to genre
rewind(); // invokes rewind by searching global scope for function
function rewind() {
	genre = "rock"; // searches inside function scope for 'genre' and assigns it 'rock'
	console.log(genre); // prints 'rock'
	genre = "r&b"; // assigns 'r&b' to genre
	console.log(genre); // prints 'r&b'
}
console.log(genre); //prints disco

//#7 Given
dojo = "san jose";
console.log(dojo);
learn();
function learn() {
	dojo = "seattle";
	console.log(dojo);
	var dojo = "burbank";
	console.log(dojo);
}
console.log(dojo);

// After
dojo = "san jose"; // dojo = 'san jose'
console.log(dojo); // prints 'san jose'
learn(); // invokes learn by searching global scope for function
function learn() {
	dojo = "seattle"; // searches inside function scope for 'dojo' and assigns is 'seattle'
	console.log(dojo); // prints 'seattle'
	dojo = "burbank"; // assigns 'burbank' to dojo
	console.log(dojo); // prints 'burbank'
}
console.log(dojo); // prints 'san jose'

// #8 Given
console.log(makeDojo("Chicago", 65));
console.log(makeDojo("Berkeley", 0));
function makeDojo(name, students){
        const dojo = {};
        dojo.name = name;
        dojo.students = students;
        if(dojo.students > 50){
            dojo.hiring = true;
        }
        else if(dojo.students <= 0){
            dojo = "closed for now";
        }
        return dojo;
}

// After
console.log(makeDojo("Chicago", 65)); // invokes makeDojo function, creates & returns object | name: 'Chicago', students: '65', hiring: true, object is printed
console.log(makeDojo("Berkeley", 0)); // errors because dojo is a constant and can't be assigned a string
function makeDojo(name, students){
        const dojo = {};
        dojo.name = name;
        dojo.students = students;
        if(dojo.students > 50){
            dojo.hiring = true;
        }
        else if(dojo.students <= 0){
            dojo = "closed for now";
        }
        return dojo;
}

