db.system.js.find({})
db.system.js.save({_id:"rand" , value:function(){ return Math.random()*10; } });
db.eval("rand()");
rand();

db.loadServerScripts();


db.EMPLOYEES.find({employee_id:100, $where:function(){ return rand()>5 }  });