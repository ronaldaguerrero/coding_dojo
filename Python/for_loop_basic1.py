#1 print all integers from 0 to 150
for x in range (151):
	print(x)


#2 Multiples of Five - Print all the multiples of 5 from 5 to 1,000
for m in range (5, 1001, 1):
	if (m % 5 == 0):
		print(m)
	
#3 Counting, the Dojo Way - Print integers 1 to 100. If divisible by 5, print "Coding" instead. If divisible by 10, print "Coding Dojo".
for d in range (1,101,1):
	if (d % 10 == 0):
		print("Coding Dojo")
		
	elif (d % 5 == 0):
		print("Coding")
		

#4 Whoa. That Sucker's Huge - Add odd integers from 0 to 500,000, and print the final sum.
total = 0
for s in range (500001):
	if (s % 2 == 1):
		total += s
	print(total)

#5 Countdown by Fours - Print positive numbers starting at 2018, counting down by fours.
year = 2018
while year % 2 == 0:
	print(year)
	year -= 4
	if year == -2:
		break

#6 Flexible Counter - Set three variables: lowNum, highNum, mult. Starting at lowNum and going through highNum, print only the integers that are a multiple of mult. For example, if lowNum=2, highNum=9, and mult=3, the loop should print 3, 6, 9 (on successive lines)
lowNum = 2
highNum = 9
mult = 3
for x in range(lowNum,(highNum + 1),1):
	if (x % mult == 0):
		print(x)
