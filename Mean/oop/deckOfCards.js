class Card {
	constructor(){
		var suits = ['Hearts', 'Clubs', 'Spades', 'Diamonds']
		var strings = ['Ace', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Jack', 'Queen', 'King']
		var values = {
			Ace: 1,
			Two: 2,
			Three: 3,
			Four: 4,
			Five: 5,
			Six: 6,
			Seven: 7,
			Eight: 8,
			Nine: 9,
			Ten: 10,
			Jack: 11,
			Queen: 12,
			King: 13,
		}
		var str = strings[Math.floor(Math.random() * 13)];
		this.suit = suits[Math.floor(Math.random() * 4)];
		this.string = str;
		var val = values[str];
		this.value = val;
	}
	show(){
		console.log(`${this.string} of ${this.suit} and the value is ${this.value}`)
	}
}

class Deck{
	constructor(){
		this.deck = [];

		var suits = ['Hearts', 'Clubs', 'Spades', 'Diamonds']
    	var strings = ['Ace', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Jack', 'Queen', 'King']

    	for (var suit in suits) {
      		for (var string in strings) {
        		this.deck.push(`${strings[string]} of ${suits[suit]}`);
      		}
    	}
	}
	shuffle(deck){
		for(let i = this.deck.length - 1; i > 0; i--){
			let j = Math.floor(Math.random() * (i+1));
			[this.deck[i], this.deck[j]] = [this.deck[j], this.deck[i]];
		}
	}
	reset(){
		this.deck = [];

		var suits = ['Hearts', 'Clubs', 'Spades', 'Diamonds']
    	var strings = ['Ace', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Jack', 'Queen', 'King']

    	for (var suit in suits) {
      		for (var string in strings) {
        		this.deck.push(`${strings[string]} of ${suits[suit]}`);
      		}
    	}
	}
	deal(){
		return this.deck.pop();
	}
}

class Player extends Deck{
	constructor(name){
		super(deck);
		this.name = name;
		this.hand = [];
	}
	takeCard(){
		this.hand.push(super.deal());
		console.log("taking a card");
		console.log(this.hand);
	}
	discardCard(num){
		this.hand.splice(num, 1);
		console.log(this.hand);
	}
}

// const card1 = new Card();
// card1.show();

const deck = new Deck();
deck.shuffle(deck);
// console.log(deck.deal());

const p1 = new Player("Ron");
console.log(p1.hand);
// p1.takeCard();
// p1.takeCard();
// p1.discardCard(1);

