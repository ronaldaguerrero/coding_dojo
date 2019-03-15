class BankAccount:
	def __init__(self, name):
		self.name = name
		self.balance = 0
		self.interest_rate = 0.05
	def deposit(self, balance):
		self.balance += balance
		return self
	def withdraw(self, balance):
		if (self.balance - balance) < 0:
			print('Insufficient funds: Charging a $5 fee')
			self.balance -= 5
		else:	
			self.balance -= balance
		return self
	def display_account_info(self):
		print('Balance: $',self.balance)
		return self
	def yield_interest(self):
		if self.balance > 0:
			self.balance += self.balance * self.interest_rate
		return self

class User:
	def __init__(self, name, email):
		self.name = name
		self.email = email
		self.account = BankAccount(name)
		return
	def example_method(self):
		self.account.deposit(100)
		print(self.account.balance)
		return
	def deposit(self,amount):
		self.account.deposit(amount)
		return self
	def withdraw(self, balance):
		if (self.account.balance - balance) < 0:
			print('Insufficient funds: Charging a $5 fee')
			self.account.balance -= 5
		else:	
			self.account.balance -= balance
		return self
	def display_account_info(self):
		print('Balance: $',self.account.balance)
		return self

# Ron = BankAccount("Ron")
# Shaq = BankAccount("Shaq")

# Ron.deposit(100).deposit(100).deposit(100).withdraw(1000).yield_interest().display_account_info()
# Shaq.deposit(1000).deposit(1000).withdraw(50).withdraw(50).withdraw(50).withdraw(50).yield_interest().display_account_info()

Ron = User("Ron","ron@email")
Ron.deposit(100).withdraw(150).display_account_info()