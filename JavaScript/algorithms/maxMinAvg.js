function maxMinAvg(arr){
  var min=arr[0];
  var max=arr[0];
  var sum=arr[0];
  var count =0;
  for(var i =1; i < arr.length;i++){
    count++;
    sum += i;
    if(arr[i] < min){
      min = arr[i];
    } else if (arr[i] > max){
      max = arr[i];
    }
  } return("The min is " + min+ " , the max is " + max + " , the avg is " + Math.floor(sum/count));
}

maxMinAvg([1,-2,9,4]);