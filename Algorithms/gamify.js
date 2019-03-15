var tigger = {
	character: 'tigger',
	greet: function(){
		console.log("The wonderful thing about Tiggers is Tiggers are wonderful things!");
	}
};
var pooh = {
	character: 'pooh',
	greet: function(){
		console.log("Oh brother....");
	}
};
var piglet = {
	character: 'piglet',
	greet: function(){
		console.log("Oh d-d-d-d-dear! I wasn't expecting company!");
	}
};
var bees = {
	character: 'bees',
	greet: function(){
		console.log("bzzzzzzzzzzzzz");
	}
};
var owl = {
	character: 'owl',
	greet: function(){
		console.log("h00000t");
	}
};
var robin = {
	character: 'robin',
	greet: function(){
		console.log("where's batman?");
	}
};
var rabbit = {
	character: 'rabbit',
	greet: function(){
		console.log("what's up doc");
	}
};
var gopher = {
	character: 'gopher',
	greet: function(){
		console.log("dirt");
	}
};
var kanga = {
	character: 'kanga',
	greet: function(){
		console.log("fanta");
	}
};
var heffalumps = {
	character: 'heffalumps',
	greet: function(){
		console.log("bumps");
	}
};
var eeyore = {
	character: 'eeyore',
	greet: function(){
		console.log("Shrek was here");
	}
};

tigger.north = pooh;

pooh.south = tigger;
pooh.west = piglet;
pooh.east = bees;
pooh.north = robin;

piglet.north = owl;
piglet.east = pooh;

bees.north = rabbit;
bees.west = pooh;

rabbit.west = robin;
rabbit.east = gopher;
rabbit.south = bees;

robin.north = kanga;
robin.west = owl;
robin.east = rabbit;
robin.south = pooh;

kanga.north = eeyore;
kanga.south = robin;

eeyore.east = heffalumps;
eeyore.south = kanga;

heffalumps.west = eeyore;

var player = {
	location: tigger,
	honey: false,
	destination: "none"
};

function mission(str){
	player.destination = str;
}

function drop(){
	if (player.location.character == player.destionation){
		console.log("Congrats!");
	} else {
		console.log("Whoops! This isn't the place that needs honey");
	}
}

function pickUp(){
	if (player.location.character == bees.character){
		player.honey = true;
		console.log("You gathered some honey!")
	} else {
		console.log('nothings here...');
	}
}

function move(dir){
	if(dir == 'north'){
		if (player.location.north != null){
			player.location = player.location.north;
			var str = player.location.character;
		}else {
			console.log('you cannot go there');
			return;
		}
	} else if (dir == 'west'){
		if (player.location.west != null){
			player.location = player.location.west;
			var str = player.location.character;
		} else {
			console.log('you cannot go there');
			return;
		}
	} else if (dir == 'east'){
		if (player.location.east != null){
			player.location = player.location.east;
			var str = player.location.character;
		} else {
			console.log('you cannot go there');
			return;
		}
	} else if (dir == 'south'){
		if (player.location.south != null){
			player.location = player.location.south;
			var str = player.location.character;
		} else {
			console.log('you cannot go there');
			return;
		}
	} 
	console.log('You are now at ' +JSON.stringify(str).replace(/"/g,'') + "'s house");
	player.location.greet();
	return;
}

mission("pooh");
move("north");
move("east");
pickUp();
drop();
move("west");
drop();
console.log(player.destination);
console.log(player.location.character);