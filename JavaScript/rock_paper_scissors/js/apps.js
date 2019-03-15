// caching from html to js for future use
let userScore = 0;
let computerScore = 0;
const userScore_span = document.getElementById('user-score');
const computerScore_span = document.getElementById('comp-score');
const scoreboard_div = document.querySelector('.scoreboard');
const result_p = document.querySelector('.result p');
const rock_div = document.getElementById('r');
const paper_div = document.getElementById('p');
const scissors_div = document.getElementById('s');
const reset_button = document.getElementById('reset');


// randomizes comp choice
function getCompChoice(){
	const choices = ['r','p','s'];
	const randomNum = (Math.floor(Math.random() * 3));
	return choices[randomNum];
}

// converts choice to word
function convertToWord(letter){
	if (letter === 'r') return 'Rock';
	if (letter === 'p') return 'Paper';
	return 'Scissors';
}

// click even listener
function main() {
	rock_div.addEventListener('click', function (){
		game('r');
	})

	paper_div.addEventListener('click', function (){
		game('p');
	})

	scissors_div.addEventListener('click', function (){
		game('s');
	})
	reset_button.addEventListener('click', function reset(){
		userScore = 0;
		userScore_span.innerHTML = userScore;
		computerScore = 0;	
		computerScore_span.innerHTML = computerScore;
	})
}
// executes listener
main();

function game(userChoice){
	const compChoice = getCompChoice();
	console.log('user choice:' + userChoice);
	console.log('comp choice:' + compChoice);
	// compares user choice w/ comp choice
	switch (userChoice + compChoice){
		case 'rs':
		case 'pr':
		case 'sp':
			won(userChoice, compChoice);
			break;
		case 'rp':
		case 'ps':
		case 'sr':
			lost(userChoice, compChoice);
			break;
		case 'rr':
		case 'pp':
		case 'ss':
			tie(userChoice, compChoice);
			break;
	}
}


function won(userChoice, compChoice){
	userScore++;
	userScore_span.innerHTML = userScore;
	const smallUText = 'user'.fontsize(1).sup()
	const smallCText = 'comp'.fontsize(1).sup()
	result_p.innerHTML = `${convertToWord(userChoice)}${(smallUText)} beats ${convertToWord(compChoice)}${smallCText}. You win! 🎰`;
	document.getElementById(userChoice).classList.add('green');
	setTimeout(function() { document.getElementById(userChoice).classList.remove('green') }, 1000);
}

function lost(userChoice, compChoice){
	computerScore++;
	computerScore_span.innerHTML = computerScore;
	const smallUText = 'user'.fontsize(1).sup()
	const smallCText = 'comp'.fontsize(1).sup()
	result_p.innerHTML = `${convertToWord(compChoice)}${smallCText} beats ${convertToWord(userChoice)}${(smallUText)}. You lost... &#128169;`;
	document.getElementById(userChoice).classList.add('red');
	setTimeout(function() { document.getElementById(userChoice).classList.remove('red') }, 1000);
}

function tie(userChoice){
	result_p.innerHTML = `Tie game...`;
	document.getElementById(userChoice).classList.add('grey');
	setTimeout(function() { document.getElementById(userChoice).classList.remove('grey') }, 1000);
}


