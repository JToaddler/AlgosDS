/*
 * Problem statements  [aggregation]
 */
 
// 1. count number of countries in in each Continent

db.W_COUNTRY.aggregate({$project: {Continent:1,Name:1}},
                       { $group: {_id : "$Continent", count : {$sum:1}}});
                       
// 2. find/list top 3 Continents having more number of countries
db.W_COUNTRY.aggregate({$project: {Continent:1, Name: 1}},
                       {$group: {"_id":"$Continent", count:{$sum:1}}},
                       {$sort: {count:-1}}).limit(3);

                       
// 3. Find/list Continents having more than 50 countries
db.W_COUNTRY.aggregate({$project: {Continent:1, Name: 1}},
                       {$group: {"_id":"$Continent", count:{$sum:1}}},
                       {$match: {"count":{$gt:50}}});
                       

// 4. Find average LifeExpectancy for each Continent with out decimal values
db.W_COUNTRY.aggregate( {$group: {"_id" : "$Continent" , "LifeExpectancyCount": {$sum: "$LifeExpectancy"} , "countyCount" :{$sum:1} }},
                        {$project:{"_id":1, "AvgLifeExpect" : {$trunc :{$divide: ["$LifeExpectancyCount", "$countyCount"]}}}} ); 


// 5. Find the City which has highest population in India
db.W_COUNTRY.aggregate({$match: {Name:"India"}},
                        {$project: {Cities:1}},
                        {$unwind:"$Cities"},
                        {$sort: {"Cities.Population":-1}},
                        {$limit: 1});


// find out the city which has the highest population ?
db.W_COUNTRY.aggregate({$unwind: "$Cities"},{$group: {"_id":"$Name", "highestPopulation" :{$max: "$Cities.Population"}}});

db.W_COUNTRY.aggregate({$unwind: "$Cities"},{$project: {Name:1, Cities:1}},{$sort: {"Cities.Population":-1}}).limit(1);

						
// Get Job Description for Employee 100 and retrun Name in the format Name : [First Name][white space][Last Name]

lookup perform left outer join.

db.EMPLOYEES.aggregate({$match:{employee_id:100}},{
    $lookup: {
           from: "JOBS",
           localField: "job_id",
           foreignField: "job_id",
           as: "job_desc"
            }
    },
    { $project: {"employee_id":1,job_desc:{job_id:1,job_title:1},"employee_name":{$concat: ["$first_name"," ","$last_name" ]}  }}
    );