from flask import Flask, render_template, request, redirect # added request
from mysqlconnection import connectToMySQL
app = Flask(__name__)
# our index route will handle rendering our form
@app.route('/')
def index():
    mysql = connectToMySQL('first_flask') #select the name of the db
    users = mysql.query_db('SELECT * FROM dojo;')
    return render_template("index.html")
            
@app.route('/result', methods=['POST'])
def create_user():
    query = 'INSERT INTO dojo (full_name, location, fave_language, comment) VALUES (%(fnm)s, %(loc)s, %(lang)s, %(comm)s);'
    data = {
        "fnm": request.form['name'], #requesting/retrieving info from '/result' based on [' ']
        "loc": request.form['loclist'],
        "lang": request.form['favelist'],
        "comm": request.form['comment']
    }
    mysql = connectToMySQL('first_flask')
    new_user_id = mysql.query_db(query,data)
    return redirect("show/"+str(new_user_id))

    #returning info to html template 'variable name' = python data

@app.route("/show/<id>")
def show_user(id):
    query = "SELECT * FROM dojo WHERE id = %(id)s;"
    data = {
        'id': id
    }
    mysql = connectToMySQL('first_flask') #select the name of the db
    the_user = mysql.query_db(query,data)
    print(the_user)
    return render_template("/show.html", user=the_user)

if __name__ == "__main__":
    app.run(debug=True)

