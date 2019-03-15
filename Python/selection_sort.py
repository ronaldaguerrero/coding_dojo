def sort([arr]):
	min = arr[0]
	max = arr[0]
	for value in arr(len(arr)):
		if arr[value] < min:
			min = arr[value]
			min,arr[value] = arr[value],min
			print(min)

sort([8,5,2,6,9,3,1,4,7])
