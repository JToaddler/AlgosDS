


mongo --host localhost --port 27017 --username hr --password --authenticationDatabase mysql

var result = db.JOBS.find({});

while(result.hasNext()){print(result.next());}

var result = db.JOBS.find({});

while(result.hasNext()){printjson(result.next());}
