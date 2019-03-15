from flask import Flask, render_template
app = Flask(__name__)
@app.route('/')
def test():
    return render_template("index.html")
@app.route('/<num>')
def rows(num):
    val = int(num)
    return render_template("index.html", times = val)

if __name__=="__main__":
    app.run(debug=True)