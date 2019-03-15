import datetime

from flask import Flask, render_template, request, redirect
app = Flask(__name__)  

@app.route('/')         
def index():
    return render_template("index.html")

@app.route('/checkout', methods=['POST'])         
def checkout():
    print(request.form)
    num_from_straw = request.form['strawberry']
    num_from_rasp = request.form['raspberry']
    num_from_app = request.form['apple']
    first_from_name = request.form['first_name']
    last_from_name = request.form['last_name']
    id_from_name = request.form['student_id']
    count = int(request.form['strawberry']) + int(request.form['raspberry']) + int(request.form['apple'])
    today_date = datetime.datetime.now().strftime("%B %m %Y %I:%M:%S %p.")

    return render_template("checkout.html", straw_from_temp=num_from_straw, rasp_from_temp=num_from_rasp, app_from_temp=num_from_app, first_name=first_from_name, last_name=last_from_name, id_name=id_from_name, count = count, date = today_date)

@app.route('/fruits')         
def fruits():
    return render_template("fruits.html")

if __name__=="__main__":   
    app.run(debug=True)    