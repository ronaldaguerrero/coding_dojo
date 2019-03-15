import random

#print(randInt()) 		    # should print a random integer between 0 to 100
def randInt(min=0, max=100):
    num = round(random.random() * 100)
    return num
print(randInt())

#print(randInt(max=50)) 	    # should print a random integer between 0 to 50
def randInt(min=0, max=50):
    num = round(random.random() * 50)
    return num
print(randInt())

#print(randInt(min=50)) 	    # should print a random integer between 50 to 100
def randInt(min=50, max=100):
    num = round(random.random() * 50 + 50)
    return num
print(randInt())

#print(randInt(min=50, max=500))    # should print a random integer between 50 and 500
def randInt(min=50, max=500):
    num = round(random.random() * 450 + 50)
    return num
print(randInt())
