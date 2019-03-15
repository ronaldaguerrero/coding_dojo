from flask import Flask, render_template, request, redirect
from mysqlconnection import connectToMySQL # import the function that will return an instance of a connection
app = Flask(__name__)
@app.route("/")
def index():
	mysql = connectToMySQL('cr_pets') # call the function, passing in the name of our db
	pets = mysql.query_db('SELECT * FROM pets;') # call the query_db function, pass in the query as a string
	return render_template("index.html", all_pets = pets)

@app.route("/create_pet", methods=["POST"])
def add_friend_to_db():
	query = 'INSERT INTO pets (name, type) VALUES (%(nm)s, %(typ)s);'

	data = {
		"nm": request.form["name"],
		"typ": request.form["type"]
	}
	mysql = connectToMySQL('cr_pets') #call name of db

	new_pet_id = mysql.query_db(query, data)
	return redirect("/")

if __name__ == "__main__":
	app.run(debug=True)
