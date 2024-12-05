/*
 * Collections
 */

db.createCollection("DEMO", {capped : false});

db.createCollection("RULE", { capped : true, size : 512 * 1024, max : 2 });

db.RULE.insert([
    {
       "rule_id"    : 1, 
       "status"     : 5,
       "queue"      : 107,
       "lob"        : "Individual",
       "rnwl_actn"  : "N",
       createdDate  : new Date()
    },
    {
       "rule_id"    : 2, 
       "status"     : 78,
       "queue"      : 107,
       "lob"        : "Individual",
       "rnwl_actn"  : "N",
       createdDate  : new Date()
    },
    {
       "rule_id"    : 3, 
       "status"     : 45,
       "queue"      : 107,
       "lob"        : "Individual",
       "rnwl_actn"  : "A",
       createdDate  : new Date()
    }
    ]);
    
    
db.RULE.find({}).count();

db.RULE.insert({
       "rule_id"    : 4, 
       "status"     : 45,
       "queue"      : 107,
       "lob"        : "Individual",
       "rnwl_actn"  : "A",
       createdDate  : new Date()
    });
    
db.RULE.find({});

db.RULE.find({}).count();


/*
 * Index 
 */ 

db.RULE.createIndex({rule_id:1},{name :"RULE_ID_INDX"});

db.RULE.createIndex({rule_id:1,status:1,queue:1},{name :"RULE_ID_INDX2",unique:true});

db.RULE2.insert({
       "rule_id"    : 1, 
       "status"     : 5,
       "queue"      : 107,
       "lob"        : "Individual",
       "rnwl_actn"  : "N",
       createdDate  : new Date()
    });

db.RULE2.createIndex({createdDate: 1}, {expireAfterSeconds: 10 });

/*
 *Partial Index is good when put different type of records in same collection
 */

db.media.insert([{ type: "Music Album", albumName : "Thriller", year : "1990" , songsCount : 6},{type: "Movie", movie : "C.I.A", releaseDate : "18/04/2016" , duration : 105 }]);

// create index only for albums
db.media.createIndex({albumName: 1},{name:"ALBUM_INDEX", unique: false, partialFilterExpression :{ albumName :{$exists: true} , type: "Music Album" } });

// create index only for movie records
db.media.createIndex({movie: 1},{name:"MOVIE_INDEX", unique: true, partialFilterExpression :{ movie :{$exists: true},  type: "Movie"} });


/*
 * Explain results
 */

db.EMPLOYEES.find({employee_id:100}).explain();

db.EMPLOYEES.find({employee_id:100}).explain(true);

// force mongod to use a specific index

db.EMPLOYEES.find({employee_id:100}).hint({employee_id:1,department_id:1}).explain();