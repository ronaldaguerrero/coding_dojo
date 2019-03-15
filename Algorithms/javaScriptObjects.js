// Challenge #1

let students = [
    {name: 'Remy', cohort: 'Jan'},
    {name: 'Genevieve', cohort: 'March'},
    {name: 'Chuck', cohort: 'Jan'},
    {name: 'Osmund', cohort: 'June'},
    {name: 'Nikki', cohort: 'June'},
    {name: 'Boris', cohort: 'June'}
];

function print(arr){
	for(var i = 0; i < arr.length; i++){
		console.log("Name: " + arr[i].name + ", Cohort: " + arr[i].cohort);
	}
}

print(students);

// Challenge #2

let users = {
    employees: [
        {'first_name':  'Miguel', 'last_name' : 'Jones'},
        {'first_name' : 'Ernie', 'last_name' : 'Bertson'},
        {'first_name' : 'Nora', 'last_name' : 'Lu'},
        {'first_name' : 'Sally', 'last_name' : 'Barkyoumb'}
    ],
    managers: [
       {'first_name' : 'Lillian', 'last_name' : 'Chambers'},
       {'first_name' : 'Gordon', 'last_name' : 'Poe'}
    ]
 };

 function char(arr){
    console.log("EMPLOYEES");
    for(var key in arr.employees){
        var lName = arr.employees[key].last_name;
        var fName = arr.employees[key].first_name;
        var len = lName.length + fName.length;
        console.log(key + " - " + lName + ", " + fName + " - " + len);
    }
    console.log("MANAGERS");
    for(var key in arr.managers){
        var lName = arr.managers[key].last_name;
        var fName = arr.managers[key].first_name;
        var len = lName.length + fName.length;
        console.log(key + " - " + lName + ", " + fName + " - " + len);
    }
}
char(users);
