
/*
	MAINT DEMO
*/
db.runCommand({
    mapReduce : "EA",
    map:function()
    {
        var exchageHist = {
                            exch_sub_id : this.EXCH_SUB_ID,
                            st_cd : this.ST_CD,
                            policy : [{
                                        wemids   : [{ wemid: this.ENROLLMENTAPPID, statusid : this.STATUSID, seq_num:this.SEQ_NUMBER}],
                                        product : this.HEALTHCOVERAGEINSURANCELINEID
                                      }]
                        };
                        
        var key ={exch_sub_id : this.EXCH_SUB_ID, st_cd:this.ST_CD};
        emit(key, exchageHist);
        
    },
    reduce : function (key , valueArray)
    {
        print(key);
        var consolidatedHist = {
                            exch_sub_id : key.exch_sub_id,
                            st_cd       : key.st_cd,
                            policy      :[]
                        };
        for(var index in valueArray)
        {
           var exchageHist = valueArray[index];
           for(var element in exchageHist.policy)
           {
                var enrollments = exchageHist.policy[element];
                
                if(enrollments.product === undefined || enrollments.product ==null)
                {
                    enrollments.product = 
                }
                
                
                consolidatedHist.policy.push(enrollments);
           }
        }
        print(" reduce --> ");
        printjson(key);
        printjson(consolidatedHist);
        return consolidatedHist;
    },
    query :{LINEOFBUSINESS : "Individual",EXCH_SUB_ID:5875755225,ST_CD:"WI"},
    sort  : {EXCH_SUB_ID:1},
    out   : "MAINT"
});

db.MAINT.find();