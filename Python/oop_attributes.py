class User:		# declare a class and give it name User
    def __init__(self):
        self.name = "Michael" #attributes for class
        self.email = "michael@codingdojo.com"
        self.account_balance = 0

guido = User() # creates new instances (variables) based on class
monty = User()

print(guido.name)	# output: Michael / accesses instance attributes
print(monty.name)	# output: Michael

guido.name = "Guido" # sets values of instance attributes
monty.name = "Monty"

class User:
    def __init__(self, username, email_address):# now our method has 2 parameters!
        self.name = username			# and we use the values passed in to set the name attribute
        self.email = email_address		# and the email attribute
        self.account_balance = 0		# the account balance is set to $0, so no need for a third parameter

guido = User("Guido van Rossum", "guido@python.com")
monty = User("Monty Python", "monty@python.com")
print(guido.name)	# output: Guido van Rossum
print(monty.name)	# output: Monty Python
