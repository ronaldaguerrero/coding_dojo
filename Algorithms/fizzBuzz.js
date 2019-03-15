function fizzbuzz(num){
  if(num <= 0){
    console.log("Paramater must be a positive number");
  }
  else {
    for(var i = 1; i <= num; i++){
    if(i%3==0 && i%5==0){
      console.log("FizzBuzz");
    } else if(i%3==0 && i%5!=0){
      console.log("Fizz");
    } else if(i%5==0 && i%3!=0){
      console.log("Buzz");
    } else{
      console.log(i);
    }
    }
  }
}

fizzbuzz(0);