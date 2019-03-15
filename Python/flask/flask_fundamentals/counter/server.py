from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key ='this is a secret shhh'

@app.route('/')
def index():
	if "counter" not in session:
		session['counter'] = 1
	else:
		session['counter'] += 1
	return render_template("index.html")

@app.route('/destroy_session')
def destroy():
	session.clear()
	return redirect('/')

@app.route('/add_two')
def addtwo():
	session['counter'] +=1
	return redirect('/')


if __name__ == "__main__":
	app.run(debug=True)