// Create a database called 'my_first_db'.
use my_first_db

// Create students collection.
db.createCollection('students')

// Each document you insert into this collection should have the following format: ({name: STRING, home_state: STRING, lucky_number: NUMBER, birthday: {month: NUMBER, day: NUMBER, year: NUMBER}})
db.students.insert({name: 'Ron', home_state: 'CA', lucky_number: 9, birthday: {month: 11, day: 15, year : 1989}})

// Create 5 students with the appropriate info.

// Get all students.
db.students.find().pretty()

// Retrieve all students who are from California (San Jose Dojo) or Washington (Seattle Dojo).
db.students.find(home_state: 'CA').pretty()

// Get all students whose lucky number is:
// greater than 3
db.students.find(lucky_number: {$gt:3})
// less than or equal to 10
db.students.find(lucky_number: {$lte: 10})
// between 1 and 9 (inclusive)
db.students.find(lucky_number: {$range: [1, 9]})

// Add a field to each student collection called 'interests' that is an ARRAY.  It should contain the following entries: 'coding', 'brunch', 'MongoDB'. Do this in ONE operation.
db.students.update({}, {$addToSet:{intersts: 'coding','brunch','MongoDB'}})

// Add some unique interests for each particular student into each of their interest arrays.
db.students.update({name:'Ron'}, {$push: {interests: 'basketball'}})

// Add the interest 'taxes' into someone's interest array.
db.students.update({name:'Ron'}, {$push: {interests: 'taxes'}})

// Remove the 'taxes' interest you just added.
db.students.update({name:'Ron'}, {$pop: {interests: (1)}})

// Remove all students who are from California.
db.students.updateMany({}, )

// Remove a student by name. 
db.students.remove({name:'Ron'})

// Remove a student whose lucky number is greater than 5 (JUST ONE)
db.students.remove({lucky_number: {$gt:5}})

// Add a field to each student collection called 'number_of_belts' and set it to 0.
db.students.updateMany({}, {$set: {number_of_belts: 0}})

// Increment this field by 1 for all students in Washington (Seattle Dojo).
db.students.updateMany({home_state: 'wa'}, {$set: {number_of_belts: 1}})

// Rename the 'number_of_belts' field to 'belts_earned'
db.students.updateMany({}, {$rename: {'number_of_belts' : 'belts_earned'}})

// Remove the 'lucky_number' field.
db.students.remove({set: '{number_of_belts'})

// Add a 'updated_on' field, and set the value as the current date.
db.students.update({}, {$set: {'updatedDate': new Date()}}, {multi: true})