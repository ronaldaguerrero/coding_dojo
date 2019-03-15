function binarySearch (Arr,value){
        var low  = 0;
        var high = Arr.length -1;
        var mid;      
        while (low <= high){
            mid = Math.floor((low+high)/2);     
            console.log('while loop');
            if(Arr[mid]==value){
            	console.log(mid);
            	return mid;
            } 
            else if (Arr[mid]<value){
            	low = mid+1;	
            } 
            else{
            	high = mid-1;
            }           
        }
        console.log('false');
        return -1 ;
    }

     binarySearch   ([1, 3, 8, 10, 12, 15, 17, 20, 22, 34, 38, 40, 50, 52, 78, 87, 90, 91, 92, 94], 35)