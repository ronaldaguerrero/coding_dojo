class Product:
	def __init__(self, name, price, category):
		self.name = name
		self.price = price
		self.category = category
		self.store = Store(name)
	def update_price(self, percent_change, is_increased):
		if is_increased == True:
			self.price += self.price * percent_change
		if is_increased	== False:
			self.price -= self.price * percent_change
		return self
	def print_into(self):
		print(self.name)
		print(self.category)
		print(self.price)
		return self

class Store:
	def __init__(self, name):
		self.name = name
		self.product = []
		# self.product = Product(name)
	def add_product(self, new_product):
		self.product.append(new_product)
		return self
	def sell_product(self, id):
		self.product.pop(id)
		return self
	def print_info(self):
		# create for loop to access each index in array to print info inside of product
		print(self.product)
		return self
	def inflation(self, percent_increase):
		self.Product.price += self.Product.price * percent_increase


target = Store("target")

wii = Product("wii", 100, "toy")

target.add_product(wii)

bestbuy = Store("bestbuy")

ps3 = Product("ps3", 200, "toy")

bestbuy.add_product(ps3).print_info()

