from flask import Flask, render_template, request, redirect, session, flash
from mysqlconnection import connectToMySQL # import the function that will return an instance of a connection
app = Flask(__name__)
app.secret_key = "secret"

@app.route("/")
def index():
	mysql = connectToMySQL('first_flask') # call the function, passing in the name of our db
	friends = mysql.query_db('SELECT * FROM friends;') # call the query_db function, pass in the query as a string
	return render_template("index.html", all_friends = friends)

@app.route("/create_friend", methods=["POST"])
def add_friend_to_db():
	is_valid = True
	if len(request.form['fname']) < 1:
		is_valid = False
		flash("Please enter a first name")
	if len(request.form['lname']) < 1:
		is_valid = False
		flash("Please enter a last name")
	if len(request.form['occ']) < 2:
		is_valid = False
		flash("Occupation should be at least 2 characters")
	if is_valid:
		query = 'INSERT INTO friends (first_name, last_name, occupation) VALUES (%(fn)s, %(ln)s, %(occup)s);'

		data = {
			"fn": request.form["fname"],
			"ln": request.form["lname"],
			"occup": request.form["occ"]
		}
		mysql = connectToMySQL('first_flask')

		new_friend_id = mysql.query_db(query, data)
		flash("Successfully added")
	return redirect("/show")

if __name__ == "__main__":
	app.run(debug=True)
