//db.DEMO.find({groupid:{$in: [100002,"100001"]}});
//db.DEMO.remove({groupid:{$in: [100002,"100001"]}});

/*
 * Insert, insertMany
 */
db.DEMO.insert(
{  
    groupid   : 100000,
    groupName : "Demo Groups",
    agentName : {
                    firstName:"Sam Jones", 
                    lastName :"Dilan", 
                    ssn :"1234567890",
                    addres :{
                            streetAddress1 : "5th street",
                             streetAddress2 : "BareHills Town",
                             stateCode      : "NY",
                             zip            : 10005
                            }
        
                },
    address   :{
                streetAddress1 : "7th Street",
                streetAddress2 : "Manhatten",
                stateCode      : "NY",
                zip            : 10012
                },
    members :[{
                firstName : "test FirstName1", 
                lastName  : "test last Name1"
            },{
                firstName : "test FirstName2", 
                lastName  : "test last Name2"
            }
            ],
    groupEffDate : new Date("01/JAN/2017"),
    endEffDate   :  new Date("31/DEC/2017"),
    isEffective : false
});

db.DEMO.insert([{  
    groupid   : "100001",
    groupName : "Test Groups",
    agentName : {
                    firstName:"Tim", 
                    lastName :"Cook", 
                    ssn :"123AB67890",
                    addres :{
                            streetAddress1 : "Sanberg Bulevard",
                             streetAddress2 : "Austin",
                             stateCode      : "TX",
                             zip            : 34785
                            }
        
                },
    address   :{
                    streetAddress1 : "Sanberg Bulevard",
                    streetAddress2 : "Austin",
                    stateCode      : "TX",
                    zip            : 34785
                },
    members :[{
                firstName : "test FirstName1", 
                lastName  : "test last Name1"
            }],
    groupEffDate : new Date("01/JAN/2016"),
    endEffDate   :  new Date("31/DEC/2017"),
    isEffective : true
    },
    {  
    groupid   : 100002,
    groupName : "Miracle Groups",
    agentName : {
                    firstName: "Bruce Miranda", 
                    lastName : "Jade", 
                    ssn      : "12390678GH",
                    addres :{
                             streetAddress1 : "Sanberg Bulevard",
                             streetAddress2 : "Austin",
                             stateCode      : "TX",
                             zip            : 34785
                            }
        
                },
    address   :{
                    streetAddress1 : "Sanberg Bulevard",
                    streetAddress2 : "Austin",
                    stateCode      : "TX",
                    zip            : 34785
                },
    members :[{
                firstName : "test FirstName1", 
                lastName  : "test last Name1"
            }],
    groupEffDate : new Date("01/JAN/2015"),
    endEffDate   :  new Date("31/DEC/2016"),
    isEffective : false
    }],
    {writeConcern : { w:1, wtimeout : 20000}, ordered: false , j:true}
    );
    
db.DEMO.insert(
{  
    groupid   : 100005,
    groupName : "Auto Parts",
    agentName : {
                    firstName:"Tim Milan", 
                    lastName :"Yong", 
                    ssn :"ABCD567890",
                    addres :{
                             streetAddress1 : "5th street",
                             streetAddress2 : "Down Town",
                             stateCode      : "NJ",
                             zip            : 10034
                            }
        
                },
    address   :{
                streetAddress1 : "7th Street",
                streetAddress2 : "Manhatten",
                stateCode      : "NJ",
                zip            : 10034
                },
    members :[{
                firstName : "test FirstName1", 
                lastName  : "test last Name1"
            },{
                firstName : "test FirstName2", 
                lastName  : "test last Name2"
            },{
                firstName : "test FirstName3", 
                lastName  : "test last Name3"
            }
            ],
    groupEffDate : new Date("01/JAN/2016"),
    endEffDate   :  new Date("31/DEC/2017"),
    isEffective : false
});
/*
 * find, findOne
 */

db.DEMO.find({});

db.DEMO.findOne({});

db.DEMO.find({isEffective :true});

db.DEMO.find({members:{$size: 1}});

db.DEMO.find({$and: [{groupid:100001},{groupName:"Test Groups"}]});

db.DEMO.find({$or: [{isEffective : false}, {groupName :/Groups$/i}]}); // regex must be compatible with PCRE

db.DEMO.find({isEffective :{$not:{$eq:true}}});

db.DEMO.find({isEffective:{$nin: [true]}});

db.DEMO.find({},{}).skip(1).limit(10);

/*
 * Update,  updteOne, full doc replacement
 */

db.DEMO.update({groupid:100005},{isEffective:true});

db.DEMO.update({groupid:100005},{$set:{groupName : "Metal Parts", }},{multi:false, upsert:false});


db.DEMO.update({groupid:"100001"},{$push:{members: { firstName : "Name Updated with $Push", lastName: "Name Updated with $Push" } }});

db.DEMO.find({"groupid":"100001"});

// add this member to array inly if this member is not present in existing array
db.DEMO.update({groupid:"100001"},{$addToSet:{members: { firstName : "Name Updated with $Push", lastName : null } }});

// remove members from array
db.DEMO.update({groupid:"100001",},{$pull: {members:{firstName :"Name Updated with $Push", lastName :null }}},{multi:false});


// full DOC replacement ( with out an operator)

db.DEMO.insert({type : "DEMO" , numbers : [1,2,3 ] });

db.DEMO.find({type : "DEMO" });

db.DEMO.update({type:"DEMO"},{NAME :"I'm the new replacement document"});

db.DEMO.find({NAME:"I'm the new replacement document"});


/*
 * remove , deleteOne, deleteMany
 */

db.DEMO.insert({type : "DEMO" , numbers : [1,2,3 ] }); // 2

db.DEMO.insert({type : "DEMO" , info :{name:"test name",id :890} });


db.DEMO.remove({NAME : "I'm the new replacement document"});

db.DEMO.deleteOne({type:"DEMO"});


db.DEMO.deleteMany({type:"DEMO"});


// delete a key unset

db.DEMO.update({_id:ObjectId("57e7df2ec62b7208064dad3d")},{$unset:{numbers:""}});