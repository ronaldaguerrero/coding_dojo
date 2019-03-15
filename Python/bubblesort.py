def selectionSort(arr):

   for i in range(len(arr)):

      # Find the minimum element in remaining
       arrNum = i # loop through array
       print('this is arrNum',arrNum)

       for j in range(i+1, len(arr)): #skips first value and goes to 2nd # in array
           if arr[arrNum] > arr[j]:
               arrNum = j
               print('this is j',arr[arrNum])
                
       # Swap the found minimum element with arrNum       
       temp = arr[i]
       print('this is the value of temp',arr[i])
       arr[i] = arr[arrNum]
       print('arr[i] is being changed to arr[i]',arr[arrNum])
       arr[arrNum] = temp
       print('arr[arrNum] is being changed to arr[arrNum]',temp)
       print(arr)

   return arr

print(selectionSort([5,9,1,7,0,4,6]))