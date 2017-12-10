/**
 * Created by Thisun Pathirage on 12/5/2017.
 */
var db = require('../database/mysqlConnection');

var Sync = {
    getStateSync: function (callback) {
        return db.query("select * from sync", callback);
    },
    getSyncById: function (id, callback) {
        if(id=="state"){
            return db.query("select state from sync", callback);
        }
        else if(id=="date"){
            return db.query("select date from sync", callback);
        }else if(id=="time"){
            return db.query("select time from sync", callback);
        }

    },
}

module.exports=Sync;