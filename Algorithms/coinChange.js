function coinChange(num){
	var change = new Object ();
	var remainder = num;
    if (remainder / 100 >= 1){
      var dCount = Math.floor(remainder/100);
      change.dollars = dCount;
      remainder = remainder - (dCount*100);
    } if (remainder / 25 >= 1){
        var qCount = Math.floor(remainder/25);
        change.quarters = qCount;
        remainder = remainder - (qCount*25);
    } if (remainder / 10 >= 1){
        var dimeCount = Math.floor(remainder/10);
        change.dimes = dimeCount;
        remainder = remainder - (dimeCount*10);
    } if (remainder / 5 >= 1){
        var nCount = Math.floor(remainder/5);
        change.nickels = nCount;
        remainder = remainder - (nCount*5);
    } if (remainder / 1 >= 1){
        var pCount = Math.floor(remainder/1);
        change.pennies = pCount;
    }
	console.log(change);
	return change;
}

coinChange(78);