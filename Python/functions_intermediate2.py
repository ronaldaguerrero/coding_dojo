#1 Update Values in Dictionaries and Lists
x = [ [5,2,3], [10,8,9] ] 
students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

x[1][0] = 15

#1a Change the value 10 in x to 15. Once you're done, x should now be [ [5,2,3], [15,8,9] ].
x[1][0] = 15

#1b Change the last_name of the first student from 'Jordan' to 'Bryant'
students[0]['last_name'] = 'Bryant'

#1c In the sports_directory, change 'Messi' to 'Andres'
sports_directory['soccer'][0] = 'Andres'

#1d Change the value 20 in z to 30
z[0]['y'] = 30

#2 Iterate Through a List of Dictionaries
#Create a function iterateDictionary(some_list) that, given a list of dictionaries, the function loops through each dictionary in the list and prints each key and the associated value. For example, given the following list:

students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]

#2 should output: (it's okay if each key-value pair ends up on 2 separate lines;
def iterateDictionary(dict):
	for person in students: 	#declares variable person and runs loop in declared dictionary
		for a, b in person.items(): 	#loops through all keys and values in loop
			print('{}: {}'.format(a,b))		#{} places declared value within '()'

iterateDictionary(students)

# bonus to get them to appear exactly as below!)
first_name - Michael, last_name - Jordan
first_name - John, last_name - Rosales
first_name - Mark, last_name - Guillen
first_name - KB, last_name - T

#3 Get Values From a List of Dictionaries
#Create a function iterateDictionary2(key_name, some_list) that, given a list of dictionaries and a key name, the function prints the value stored in that key for each dictionary. For example, iterateDictionary2('first_name', students) should output:
def iterateDictionary2(key_name, some_list):
	for v in students: 	#declares variable person and runs for loop in dictionary 
		print('{}'.format(v[key_name]))	#{} places first declared value within '()' 

iterateDictionary2('first_name',students)
#key_name = 'first_name'
#calling list 'students'

iterateDictionary2('last_name', students)

#4 Iterate Through a Dictionary with List Values
# Create a function printInfo(some_dict) that given a dictionary whose values are all lists, prints the name of each key along with the size of its list, and then prints the associated values within each key's list. For example:
dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}

def printInfo(some_dict):
	for k, v in some_dict.items():
		print(len(v))
		for x in v:
			print(x)

printInfo(dojo)
