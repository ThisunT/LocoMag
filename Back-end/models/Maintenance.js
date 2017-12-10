
var db = require('../database/mysqlConnection');

var Maintenance = {
    getAllWIP: function (callback) {
        return db.query("select * from maintenance_done", callback);
    },
    getWIPById: function (id, callback) {
        if(id=="id"){
            return db.query("select maintenance_ID from maintenance_done", callback);
        }else{
            return db.query("select * from maintenance_done where maintenance_ID=?", [id], callback);
        }

    },
    addWIP: function (maintenance, callback) {
        return db.query("insert into added_maintain(date,note,suggestion,name,type,current_state_of_engine,engine_class,engine_no) values(?,?,?,?,?,?,?,?)", [maintenance.date, maintenance.note, maintenance.suggestion,maintenance.name,maintenance.type,maintenance.engineNo,maintenance.engineClass,maintenance.currentState], function (err, count) {//oooooooooooooooooo
            if (err) {
                callback(err, null);
            } else {
                db.query("SHOW TABLE STATUS LIKE 'trip'", callback);
            }
        })
    },
    deleteWIP: function (id, callback) {
        return db.query("delete from maintenance_done where maintenance_ID=?", [id], callback);
    },
}

module.exports=Maintenance;