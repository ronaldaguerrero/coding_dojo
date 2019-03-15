from flask import Flask, render_template
app = Flask(__name__)
@app.route('/play')
def index():
    return render_template("index.html", times=3)
@app.route('/play/<num>')
def play(num):
    val = int(num)
    return render_template("index.html", times = val)
@app.route('/play/<num>/<color>')
def color(num,color):
    val = int(num)
    return render_template("index.html", times = val, color = color)

if __name__=="__main__":
    app.run(debug=True)