function bubbleSort(arr){
  var temp = 0;
  var swap = false;
  for(var i = 0; i < arr.length-1; i++){
    swap = false;
    for(var j = 0; j < arr.length - (i-1); j++){
      if(arr[j+1] < arr[j]){
        temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
        swap = true;
      } if (swap === false){
        console.log('broke');
        break;
      }
    }
  }
  console.log(arr);
  return arr;
}

bubbleSort([5,3,1,2,7]);

// printArray => O(n)
// findNth => O(1)
// halving => O(n)
// identiyMatrix => O(n^2)