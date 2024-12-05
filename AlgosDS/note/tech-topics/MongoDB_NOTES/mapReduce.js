db.runCommand({
                mapReduce : "EMPLOYEES",
                map : function()
                {
                    var manager = {
                        
                        reportees : [{
                                        employee_id : this.employee_id,
                                        first_name :this.first_name,
                                        job_id :this.job_id
                                    }],
                        manger_id : this.manager_id
                    };
                    emit(this.manager_id, manager);
                },
                reduce: function(key, valueArray)
                {
                    var manager = {reportees : [], manger_id:key };
                    for(var index in valueArray)
                    {
                        for(var elementIndex in valueArray[index].reportees)
                        {
                             manager.reportees.push(valueArray[index].reportees[elementIndex]);
                        }
                    }
                    return manager;
                },
                finalize :function(key, managerObject)
                {
                    print("finalize -->>"+key);
                    printjson(managerObject);
                },
                out : {replace:"MAPDEMO",},
                sort :{manager_id:1},
                query : {manager_id:{$exists: true}}
            });

db.MAPDEMO.find({});


