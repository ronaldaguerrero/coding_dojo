class User:		# here's what we have so far
	def __init__(self, name, email):
		self.name = name
		self.email = email
		self.account_balance = 0
	# adding the deposit method
	def make_deposit(self, amount):
		self.account_balance += amount
		return self
	# adding the withdrawal method
	def make_withdrawal(self, amount):
		self.account_balance -= amount
		return self
	# display the user balance
	def display_user_balance(self):
		print(self.name,self.account_balance)
		return self
	# transfer balance from 1 user to another
	def transfer_money_method(self,other_user,amount):
		self.make_withdrawal(amount)
		other_user.make_deposit(amount)
		return self

guido = User("ron gue","rag@gmail.com")
monty = User("gue","gar@gmail.com")

guido.make_deposit(100).make_deposit(200).make_deposit(300).make_withdrawal(50).display_user_balance()
monty.make_deposit(50).make_withdrawal(25).display_user_balance()

#create 3 instances
hawks = User("J Lin","jl@gmail.com")
lakers = User("L James","lj@gmail.com")
knicks = User("K P","kp@gmail.com")

#3 deposits and 1 withdrawal to 1st user
hawks.make_deposit(11).make_deposit(22).make_deposit(33).make_withdrawal(5).display_user_balance()

#2 deposits and 2 withdrawals to 2nd user
lakers.make_deposit(50).make_deposit(100).make_withdrawal(11).make_withdrawal(22).display_user_balance()

#1 deposit and 3 withdrawals to 3rd user
knicks.make_deposit(1000).make_withdrawal(211).make_withdrawal(999).make_withdrawal(201).display_user_balance()

hawks.transfer_money_method(lakers,100).display_user_balance()
lakers.display_user_balance()