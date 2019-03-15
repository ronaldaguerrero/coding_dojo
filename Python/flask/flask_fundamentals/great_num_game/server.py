from flask import Flask, render_template, request, redirect, session
from random import *

app = Flask(__name__)
app.secret_key = 'the great number game'


@app.route('/')
def index():
	myNumber = int(randint(1,100))
	session['myNumber'] = myNumber
	print ('this is the #', session['myNumber'])
	return render_template("index.html")

@app.route('/guess', methods=['POST'])
def checkNum():
	session['myGuess'] = int(request.form['myGuess'])
	print ('the guess is', session['myGuess'])
	print (session['myNumber'])
	return render_template("show.html", myGuess = session['myGuess'], myNumber = session['myNumber'])

@app.route('/reset', methods=['GET', 'POST'])
def reset():
    return redirect('/')

if __name__ == "__main__":
	app.run(debug=True)
