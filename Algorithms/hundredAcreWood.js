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