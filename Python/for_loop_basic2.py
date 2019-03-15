#1 Biggie Size - Given a list, write a function that changes all positive numbers in the list to "big".
#Example: biggie_size([-1, 3, 5, -5]) returns that same list, but whose values are now [-1, "big", "big", -5]

def big(list):
	newlist = []
	for x in range(0,len(list)):
		if list[x] > 0:
			newlist.append("big")
		else: 
			newlist.append(list[x])
		continue
	return newlist

print(big([-1,3,5,-5]))

#2 Count Positives - Given a list of numbers, create a function to replace the last value with the number of positive values. (Note that zero is not considered to be a positive number).
#Example: count_positives([-1,1,1,1]) changes the original list to [-1,1,1,3] and returns it
#Example: count_positives([1,6,-4,-2,-7,-2]) changes the list to [1,6,-4,-2,-7,2] and returns it

def positives(list):
	positive = 0
	for x in range(0,len(list)):
		if list[x] > 0:
			positive += list[x]
	list.pop(-1)
	list.append(positive)	
	return list


print(positives([-1,1,1,1]))
print(positives([1,6,-4,-2,-7,-2]))

#3 Sum Total - Create a function that takes a list and returns the sum of all the values in the array.
#Example: sum_total([1,2,3,4]) should return 10
#Example: sum_total([6,3,-2]) should return 7

def sum(list):
	total = 0
	for x in range(0,len(list)):
		total += list[x]
	return total

print(sum([1,2,3,4]))
print(sum([6,3,-2]))

#4 Average - Create a function that takes a list and returns the average of all the values.
#Example: average([1,2,3,4]) should return 2.5

def average(list):
	total = 0
	for x in range(0,len(list)):
		total += list[x]
	return total / len(list)

print(average([1,2,3,4]))

#5 Length - Create a function that takes a list and returns the length of the list.
#Example: length([37,2,1,-9]) should return 4
#Example: length([]) should return 0

def length(list):
	return len(list)

print(length([37,2,1,-9]))
print(length([]))

#6 Minimum - Create a function that takes a list of numbers and returns the minimum value in the list. If the list is empty, have the function return False.
# Example: minimum([37,2,1,-9]) should return -9
# Example: minimum([]) should return False

def minimum(list):
	if list == []:
		return False
	else:
		minimum = list[0]
		for x in range (1,len(list)):
			if list[x] < minimum:
				minimum = list[x]
		return minimum	

print(minimum([37,2,1,-9]))
print(minimum([]))

#7 Maximum - Create a function that takes a list and returns the maximum value in the array. If the list is empty, have the function return False.
#Example: maximum([37,2,1,-9]) should return 37
#Example: maximum([]) should return False

def maximum(list):
	if list == []:
		return False
	else:
		maximum = list[0]
		for x in range(0,len(list)):
			if list[x] > maximum:
				maximum = list[x]
		return maximum

print(maximum([37,2,1,-9]))

#8 Ultimate Analysis - Create a function that takes a list and returns a dictionary that has the sumTotal, average, minimum, maximum and length of the list.
#Example: ultimate_analysis([37,2,1,-9]) should return {'sumTotal': 31, 'average': 7.75, 'minimum': -9, 'maximum': 37, 'length': 4 }

def ultiA(list):
	sumTotal = list[0]
	minimum = list[0]
	maximum = list[0]
	length = len(list)
	for x in range(1,len(list)):
		sumTotal += list[x]
		if list[x] < minimum:
			minimum = list[x]
		if list[x] > maximum:
			maximum = list[x]
	average = sumTotal / len(list)

	thisdict = {
	"sumTotal": sumTotal,
	"average": average,
	"minimum": minimum,
	"maximum": maximum,
	"length": length
	}
	return thisdict

print(ultiA([37,2,1,-9]))

#9 Reverse List - Create a function that takes a list and return that list with values reversed. Do this without creating a second list. (This challenge is known to appear during basic technical interviews.)
#Example: reverse_list([37,2,1,-9]) should return [-9,1,2,37]

def reverse(list):
	lastI = len(list)-1 #2nd to last int
	for x in range(0, int(len(list)/2)): 
		temp = list[x] #stores current value of x in array
		list[x] = list[lastI-x] #changes current array value with temp/2nd to last int
		list[lastI-x] = temp #changes 
	return list

print(reverse([37,2,1,-9]))


