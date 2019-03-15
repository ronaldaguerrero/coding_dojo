from flask import Flask, render_template, request, redirect, session
from mysqlconnection import connectToMySQL
import datetime

app = Flask(__name__)
@app.route("/users/new")
def index():
    mysql = connectToMySQL('users') #select the name of the db
    users = mysql.query_db('SELECT * FROM users;')
    return render_template("index.html", all_users = users)

@app.route("/users/create", methods=["POST"])
def add_user():
    query = 'INSERT INTO users (first_name, last_name, email) VALUES (%(fnm)s, %(lnm)s, %(em)s);'
    data = {
        "fnm": request.form["first_nm"],
        "lnm": request.form["last_nm"],
        "em": request.form["email"]
    }
    mysql = connectToMySQL('users')
    new_user_id = mysql.query_db(query,data)
    return redirect("/show/"+str(new_user_id))

@app.route("/show/<id>")
def show_user(id):
    query = "SELECT * FROM users WHERE id = %(id)s;"
    data = {
        'id': id
    }
    mysql = connectToMySQL('users') #select the name of the db
    the_user = mysql.query_db(query,data)
    return render_template("/show.html", user=the_user)

@app.route("/users")
def show_all():
    mysql = connectToMySQL('users') #select the name of the db
    users = mysql.query_db('SELECT * FROM users;')
    return render_template("show_all.html", all_users = users)

@app.route("/edit/<id>")
def show_edit(id):
    query = 'SELECT * FROM users WHERE id = %(id)s;'
    data = {
        'id': id
    }
    mysql = connectToMySQL('users')
    user_id = mysql.query_db(query,data)
    return render_template("/edit.html", user=user_id)

@app.route("/users/<id>/update", methods=["POST"])
def edit_user(id):
    query = 'UPDATE users SET first_name=%(fnm)s, last_name=%(lnm)s, email=%(em)s WHERE id=%(id)s;'
    data = {
        "fnm": request.form["fnm"],
        "lnm": request.form["lnm"],
        "em": request.form["em"],
        'id': id
    }
    mysql = connectToMySQL('users')
    new_user_id = mysql.query_db(query,data)
    return redirect("/show/"+str(id))

@app.route("/home")
def home():
    return redirect("/users")

@app.route("/delete/<id>")
def delete(id):
    query = "DELETE FROM users WHERE id = %(id)s;"
    data = {
        'id': id
    }
    mysql = connectToMySQL('users') #select the name of the db
    the_user = mysql.query_db(query,data)
    return redirect("/users")


if __name__ == "__main__":
	app.run(debug=True)
