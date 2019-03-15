function print1To255(){
    for (i = 1; i <= 255;i++){
        console.log(i);
    }
}

print1To255();

function printOdds1To255(){
    for (i = 1; i <= 255;i++){
        if (i % 2 === 1){
            console.log(i);
        }   
    }
}

printOdds1To255();

function printIntsAndSum0To255(){
    var sum = 0;
    for (i = 0; i <=255;i++){
           console.log(i);
           sum+=i;
           console.log(sum);
       }
    }

printIntsAndSum0To255();

var myArr = [10,1,12,9]
function printArrayVals(arr){
    for (i = 0; i < arr.length;i++){
        console.log(arr[i]);
    }
}

printArrayVals(myArr);

function printMaxOfArray(arr){
    var max = arr[0];
    for (var i = 0; i< arr.length; i++){
        if (max < arr[i]){
            max = arr[i];
        }
    }
    console.log(max);
}

printMaxOfArray([10,1,12,9]);

function printAverageOfArray(arr){
    var sum = 0;
    for (var i = 0; i < arr.length;i++){
        sum += arr[i];
        var avg = sum / arr.length;{
        console.log(avg);
        }
    }
}

printAverageOfArray([10,1,12,9]);


function ReturnOddsArray1To255(arr){
    var new_array = [];
    for (var i = 0; i <= 255; i++){
        if (i % 2 === 1){
            new_array.push(i);
        }
    }
    return new_array;
}
var odds = ReturnOddsArray1To255();
console.log(odds);

function squareArrayVals(arr){
    for (var i = 0; i < arr.length; i++){
        arr[i] = arr[i] * arr[i];
    }
    return arr;
}
squareArrayVals(233);

function returnArrayCountGreaterThanY(arr,y){
    var count = 0;
    for (var i = 0; i < arr.length; i++){
        if (arr[i] > y){
            count++;
        }
    }
    console.log(count);
    return count;
}

returnArrayCountGreaterThanY([11,10,101,999],11);

function zeroOutArrayNegativeVals(arr){
    var myArr = arr;
    for (var i = 0; i < arr.length; i++){
        if (arr[i] < 0){
            arr[i] = 0;
        }
    }
    return myArr;
}

zeroOutArrayNegativeVals([-1,3,-5,6]);

function printMaxMinAverageArrayVals(arr){
    var max = arr[0];
    var min = arr[0];
    var sum = 0;
    for (var i = 0; i < arr.length;i++){
        if (max < arr[i]){
            max = arr[i];
        }
        if (min > arr[i]){
            min = arr[i];
        }
        sum += arr[i];
    }
    console.log(max);
    console.log(min);
    console.log(sum/arr.length);
}
printMaxMinAverageArrayVals([10,2,5,20]);

function shiftArrayValsLeft(arr){
    for (var i = 0; i < arr.length-1; i++){
        arr[i] = arr[i+1];
    }
    arr[arr.length-1]=0;
    return arr;
}
shiftArrayValsLeft([10,1,12,9]);

function swapStringForArrayNegativeVals(arr){
    var myArr = arr;
    for (var i = 0; i < arr.length; i++){
        if (arr[i] < 0){
            arr[i] = ("Dojo");
        }
    }
    return myArr;
}

swapStringForArrayNegativeVals([-1,3,-5,6]);