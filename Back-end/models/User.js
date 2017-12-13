/**
 * Created by Thisun Pathirage on 12/5/2017.
 */
var db = require('../database/mysqlConnection');

var User = {
    getAllUsers: function (callback) {
        return db.query("select * from user", callback);
    },
    getUserByUsername: function (username, callback) {

            return db.query("select * from user where username=?", [username], callback);
    },
    addUser: function (user, callback) {
        return db.query("insert into user(date_today,employee_ID,username,pwd) values(?,?,?,?)", [user.date_today, user.employee_ID, user.username, user.pwd], function (err, count) {
            if (err) {
                callback(err, null);
            }
            else {
                db.query("SHOW TABLE STATUS LIKE 'user'", callback);
            }
        })
    },
    deleteUser: function (employee_ID, callback) {
        return db.query("DELETE FROM `locomagazine`.`user` WHERE `user`.`ID` = ?", [employee_ID], callback);
    },
}

module.exports=User;