/**
 * Created by Thisun Pathirage on 12/5/2017.
 */
var db = require('../database/mysqlConnection');

var Trip = {
    getAllTrips: function (callback) {
        return db.query("select * from trip", callback);
    },
    getTripById: function (id, callback) {
        if(id=="id"){
            return db.query("select loco_ID from trip", callback);
        }else{
            return db.query("select * from trip where loco_ID=?", [id], callback);
        }

    },
    addTrip: function (trip, callback) {
        return db.query("insert into trip(route_ID,driver_ID,guard_ID,loco_ID,date,start_time,trip_details,any_failures) values(?,?,?,?,?,?,?,?)", [trip.routeId, trip.driverId, trip.guardId, trip.locoId, trip.date, trip.startTime, trip.tripDetails, trip.failures], function (err, count) {
            if (err) {
                callback(err, null);
            } else {
                db.query("SHOW TABLE STATUS LIKE 'trip'", callback);
            }
        })
    },
    deleteTrip: function (id, callback) {
        return db.query("delete from trip where ID=?", [id], callback);
    },
}

module.exports=Trip;