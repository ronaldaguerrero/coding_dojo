 //1 Rewrite the given code as it is seen by the interpreter
 //2 Predict the outputs
 //3 Run the original code and compare the outputs to your predictions

//#1 Given
console.log(hello);                                   
var hello = 'world';  

// After
var hello;
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
var needle;
function test(){
	var needle;
	needle = 'magnet'; // needle is assigned 'magnet'
	console.log(needle); // prints 'magnet'
}
needle = 'haystack';
test(); // test is invoked by searching global scope


//#3 Given
var brendan = 'super cool';
function print(){
	brendan = 'only okay';
	console.log(brendan);
}
console.log(brendan);

// After
var brendan;
function print(){
	brendan = 'only okay'; // brendan doesn't exist
	console.log(brendan); // prints nothing
}
brendan = 'super cool'; // brendan is assigned 'super cool'
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
var food;
function eat(){
	var food;
	food = 'gone'; // food is assigned gone
	console.log(food); // prints gone
	food = 'half-chicken'; // assigns food 'half-chicken'
}
food = 'chicken'; // food is assigned 'chicken'
console.log(food); // prints 'chicken'
eat(); // invokes eat by searching global scope


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
console.log(food); 
mean = function() { 
	var food;
	food = "fish"; 
	food = "chicken"; 
	console.log(food); 
	console.log(food); 
}
mean();

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
var genre;
genre = "disco"; // assigns 'disco' to genre
function rewind() {
	var genre;
	genre = "rock"; // searches inside function scope for 'genre' and assigns it 'rock'
	console.log(genre); // prints 'rock'
	genre = "r&b"; // assigns 'r&b' to genre
	console.log(genre); // prints 'r&b'
}
rewind(); // invokes rewind by searching global scope for function
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

