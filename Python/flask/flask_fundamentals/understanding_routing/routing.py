from flask import Flask
app = Flask(__name__)
@app.route('/')
def hello_world():
	return "Hello World!"

@app.route('/dojo')
def dojo():
	return "Dojo!"

@app.route('/say/<name>')
def hi(name):
	val = name
	if (val.isdigit()):
		return "Not a string"
	else:
		return "Hi " + name

@app.route('/repeat/<num>/<word>')
def repeat(num,word):
	val = num
	string = word
	if (val.isdigit()):
		print("Integer present")
	else:
		return "Not an Integer"
	if (string.isdigit()):
		return "Not a string"
	return (word + " ") * int(num)

if __name__=="__main__":	# Ensure this file is being run directly and not from a different module    
	app.run(debug=True)		# Run the app in debug mode.

							#import statements, maybe some other routes
