var tigger = {character: 'tigger'};
var pooh = {character: 'pooh'};
var piglet = {character: 'piglet'};
var bees = {character: 'bees'};
var owl = {character: 'owl'};
var robin = {character: 'robin'};
var rabbit = {character: 'rabbit'};
var gopher = {character: 'gopher'};
var kanga = {character: 'kanga'};
var heffalumps = {character: 'heffalumps'};
var eeyore = {character: 'eeyore'};

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

var player = {location: tigger};

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
	return;
}

move("north");
move("north");
move("north");
move("west");