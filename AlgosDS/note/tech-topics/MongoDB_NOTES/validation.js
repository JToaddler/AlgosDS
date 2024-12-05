db.createCollection("PERSON",{
                            capped:false,
                            validator :{
                                        $and: [{fName:{$type:"string", $exists: true}},
                                               {ssn:{$type:"string", $exists: true }},
                                               {dob :{$type: "date", $exists: true}},
                                               {isTobacco :{$type:"bool"}},
                                               {address :{$type: "object"}},
                                               {gender :{$in: ["F","M"]}}
                                                ]
                                        }
                            });

// correct document
db.PERSON.insert({
                fName   : "Imman",
                lName   : null,
                ssn     : "123456ASKL",
                dob     : new Date("21/03/1997"),
                gender  : "M",
                isTobacco : false,
                address :{"zip":50001},
                dependent :[{"":""}]
            });


// invalid correct document [incorrect gender ]

db.PERSON.insert({
                fName   : "Gylan",
                lName   : "Rahim",
                ssn     : "784556AZKO",
                dob     : new Date("21/03/1987"),
                gender  : "",
                isTobacco : false,
                address :{},
                dependent :[{"":""}]
            });