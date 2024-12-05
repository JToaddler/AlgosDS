// Projtection

db.EMPLOYEES.find({},{});

db.EMPLOYEES.find({},{employee_id:2, first_name : 1, last_name:1, job_id:1});

db.EMPLOYEES.find({},{employee_id:1, first_name : 1, last_name:1, job_id:1, _id:0});

db.EMPLOYEES.find({},{department_id:0, manager_id :0, _id:0, reportees:0});

// sub doc

db.COUNTRIES.find({},{locations:1});

// can't mix exclusion & inclusion

db.EMPLOYEES.find({},{department_id:0, manager_id :0, _id:0, reportees:0, first_name:1});



// Query criteria

db.EMPLOYEES.find({});

db.EMPLOYEES.find({employee_id:{$in: [206,101 ,104, 106]}});

db.REGIONS.find({"countries.locations.departments.department_name": "IT"},{});

db.EMPLOYEES.find({$or: [{job_id:"IT_PROG", department_id : 60}]});

db.EMPLOYEES.find({job_id:"IT_PROG", department_id : 60});


db.W_COUNTRY.find({Name:{$regex: /land$/}});


/*
 * Type safe query
 */

db.EMPLOYEES.find({ $and: [{job_history:{$exists: false}}]});

// type safe update incorrect
db.EMPLOYEES.update({employee_id:206},{$set: {department_id:"110"}});

db.EMPLOYEES.find({department_id:"110" , employee_id:206});

db.EMPLOYEES.find({department_id:{$type: "string"}});

db.EMPLOYEES.find({department_id:{$type: 2}});



/*
 * Querying Array  & sub documents
 */
db.TEAM.insert([{name :"1stTeam", playerid:[1,5,8,9,22,33]}
               ,{name:"2ndTeam",playerid:[21,1,22,20,25,22,33]}
               ,{name:"3rdTeam",playerid:[30,33,38,39,36]}]);

db.TEAM.find({playerid:5});

db.TEAM.find({playerid:[5,33]});


// identify team squad which has payer 39 and 36

db.TEAM.find({playerid:{$all: [39,36]}});

// identify squad which has player ID greater than 33

db.TEAM.find({playerid:{$elemMatch: {$gt:30}}});


// elemMatch in Projection

db.W_COUNTRY.find({"Name":"India", "Cities.Name":"Coimbatore"});

db.W_COUNTRY.find({"Name":"India"},{"Cities" :{$elemMatch: {Name:"Coimbatore"}}});

// there is another way to get the specific array element using unwind
