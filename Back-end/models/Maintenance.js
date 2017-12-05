/**
 * Created by Thisun Pathirage on 12/5/2017.
 */
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
        return db.query("insert into maintenance_done(maintenance_ID,loco_ID,date,note,	suggestion) values(?,?,?,?,?)", [maintenance.maintenanceId, maintenance.locoId, maintenance.date, maintenance.note, maintenance.suggestion], function (err, count) {
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