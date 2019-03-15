//Biggie Size - Given an array, write a function that changes all positive numbers in the array to the string "big".  Example: makeItBig([-1,3,5,-5]) returns that same array, changed to [-1, "big", "big", -5].
function biggie(arr){
    for(var i=0; i < arr.length; i++){
        if (arr[i] > 0){
            arr[i] = 'big'}
    }
    return arr;
}
biggie([-1,3,5,-5]);

//Print Low, Return High - Create a function that takes in an array of numbers.  The function should print the lowest value in the array, and return the highest value in the array.
function lowHigh(arr){
    var high = arr[0];
    var low = arr[0];
    for(var i = 1; i < arr.length;i++){
        if (high < arr[i]){
            high = arr[i];
        }
        if (low > arr[i]){
            low = arr[i];
        }
    }
    console.log(low);
    return high;
}
    
lowHigh([1,2,3,4]);

//Print One, Return Another - Build a function that takes in an array of numbers.  The function should print the second-to-last value in the array, and return the first odd value in the array.
function printReturn(arr){
    console.log([arr.length - 1]);
    for(var i = 0; i < arr.length;i++){
        if (arr[i] % 2 == 1);
            return arr[i];
    }
}
printReturn([2,5,2,3,4]);

function printReturn(arr){
    var lastindex = arr.length-1;
    var secondlast = arr[lastindex];
    console.log(secondlast);
    for (var i=0;i<arguments.length;i++){
        if(arr[i]%2==1){
            return arr[i];
        }
    }
}
printReturn([2,5,2,3,4]);

// check this 1

//Double Vision - Given an array (similar to saying 'takes in an array'), create a function that returns a new array where each value in the original array has been doubled.  Calling double([1,2,3]) should return [2,4,6] without changing the original array.
function double(arr){
    var newarr = [];
    for(var i = 0; i < arr.length;i++){
        newarr.push (arr[i] * 2);
    }
    return newarr;
}
double([1,2,3]);

//Count Positives - Given an array of numbers, create a function to replace the last value with the number of positive values found in the array.  Example, countPositives([-1,1,1,1]) changes the original array to [-1,1,1,3] and returns it.
function countP(arr){
    var count = 0;
    for (var i = 0;i < arr.length;i++){
        if (arr[i] > 0){
            count+= 1;
        }
    }
    arr.pop();
    arr.push(count);
    return arr;
}
countP([-1,1,1,1]);

//Evens and Odds - Create a function that accepts an array.  Every time that array has three odd values in a row, print "That's odd!".  Every time the array has three evens in a row, print "Even more so!".
function evenNOdds(arr){
    for(var i=0;i < arr.length;i++){
        if (arr[i]%2===1){
            if (arr[i+1]%2===1){
                if (arr[i+2]%2===1){
                    console.log("That's odd!")
                        }
                    }
                }
        else if (arr[i]%2===0){
            if (arr[i+1]%2===0){
                if (arr[i+2]%2===0){
                    console.log("Even more so!")
                }
            }
        }
    }
}
evenNOdds([2,2,2,1,1,2,1]);

// function evenNOdds(arr){
//     var evens = 0;
//     var odds = 0;
//     for (var i = 0;i<arr.length; i++){
//         if(arr[i]%2==0){
//             evens++;
//             odds=0;
//         }
//         if(arr[i]%2==1){
//             odds++;
//             evens=0;
//         }
//         if(odds===3){
//             console.log("That's odd!");
//         }
//         if(evens===3){
//             console.log("Even more so!");
//         }
//     }
// }
// evenNOdds([2,2,1,1,1,2,1]);

// Increment the Seconds - Given an array of numbers arr, add 1 to every other element, specifically those whose index is odd (arr[1], arr[3], arr[5], etc).  Afterward, console.log each array value and return arr.
function incNSec(arr){
    for(var i=0; i<arr.length;i++){
        if(i%2==1){
            arr[i]++;
        }
    }
    for(var i=0;i<arr.length;i++){
        console.log(arr[i]);
    }
    return arr;
}
incNSec([1,2,3,4,5,6]);

//Previous Lengths - You are passed an array (similar to saying 'takes in an array' or 'given an array') containing strings.  Working within that same array, replace each string with a number - the length of the string at the previous array index - and return the array.  For example, previousLengths(["hello", "dojo", "awesome"]) should return ["hello", 5, 4]. Hint: Can for loops only go forward?
// 1. Iterate through array
// 2. Save the len of the string in variable
// 3. Write the variable into the index ahead of the current one (i+1)

function preLen(arr){
    for(var i = arr.length-1; i>0;i--){ // example of backwords for loop
        var length = arr[i-1].length;
        arr[i] = length;
    }
    return arr;
}
preLen(["hello","dojo","awesome"]);
    

//Add Seven to Most - Build a function that accepts an array. Return a new array with all the values of the original, but add 7 to each. Do not alter the original array.  Example, addSeven([1,2,3]) should return [8,9,10] in a new array.
function a7(arr){
    var newarr =[];
    for(var i =0; i < arr.length;i++){
        newarr.push (arr[i]+7);
    }
    return newarr;
}
a7([1,2,3]);

//Reverse Array - Given an array, write a function that reverses its values, in-place.  Example: reverse([3,1,6,4,2]) returns the same array, but now contains values reversed like so... [2,4,6,1,3].  Do this without creating an empty temporary array.  (Hint: you'll need to swap values).
// reverse ([3,1,6,4,2])
// 1. Create a loop that goes up to arr.length/2
// 2. Swap values in the array on opposite sides of the middle
// (swapping index 0 w/ 4, swap 1 w/ 3)

function reverse(arr){
    var lastI = arr.length-1;
    for (var i =0;i < arr.length/2;i++){
        var temp = arr[i];
        arr[i] = arr[lastI-i];
        arr[lastI-i] = temp;
    }
    return arr;
}
reverse([3,1,6,4,2,1]);

//Outlook: Negative - Given an array, create and return a new one containing all the values of the original array, but make them all negative (not simply multiplied by -1). Given [1,-3,5], return [-1,-3,-5].
function outlook(arr){
    var newarr = [];
    for(var i = 0; i < arr.length;i++){
        if (arr[i] < 0){
            newarr.push (arr[i]);}
        else if (arr[i] > 0){
            newarr.push ((arr[i] / -1));
        }
    }
    return newarr;
}
outlook([1,-3,5]);

//Always Hungry - Create a function that accepts an array, and prints "yummy" each time one of the values is equal to "food".  If no array values are "food", then print "I'm hungry" once.
function hungry(arr){
    var hungry = 0;
    for (var i = 0; i < arr.length;i++){
        if (arr[i] != "food"){
            hungry++;}
        else if (arr[i] = "food"){
            console.log ("yummy");
        }
    }
    if (hungry > 0){
        console.log("I'm hungry")
    }
}
hungry(["food","food","food","no","no"]);

// function hungry(arr){
//     var food = false;
//     for (var i =0; i< arr.length;i++){
//         if(arr[i]=="food"){
//             console.log("yummy");
//             food = true;
//         }
//     }
//     if (food=false){
//         console.log("I'm hungry");
//     }
// }
// hungry(["no","food","food","no","no"]);

//Swap Toward the Center - Given an array, swap the first and last values, third and third-to-last values, etc.  Example: swapTowardCenter([true,42,"Ada",2,"pizza"]) turns the array into ["pizza", 42, "Ada", 2, true].  swapTowardCenter([1,2,3,4,5,6]) turns the array into [6,2,4,3,5,1].  No need to return the array this time.
function reverse(arr){
    var lastI = arr.length-1;
    for (var i =0;i < arr.length/2;i=i+2){
        var temp = arr[i];
        arr[i] = arr[lastI-i];
        arr[lastI-i] = temp;
    }
    return arr;
}
reverse([1,2,3,4,5,6])

//Scale the Array - Given an array arr and a number num, multiply all values in the array arr by the number num, and return the changed array arr.  For example, scaleArray([1,2,3], 3) should return [3,6,9].
function scale(arr, num){
    for(var i = 0; i < arr.length;i++){
        arr[i] = arr[i] * num;
    }
    return arr;
}
scale([1,2,3],3);