var db = require('../database/mysqlConnection');

var Locomotive = {
    getAllLocomotives: function (callback) {
        return db.query("select * from locomotive", callback);
    },
    getLocomotiveById: function (id, callback) {
        if(id=="id"){
            return db.query("select EngineNumber from locomotive", callback);
        }else{
            return db.query("select * from locomotive where EngineNumber=?", [id], callback);
        }

    },
    addLocomotive: function (locomotive, callback) {
        return db.query("insert into locomotive(EngineNumber,EngineType,Today,Shed,Manufacturer,TopSpeed,ManufacturedDay,State) values(?,?,?,?,?,?,?,?)", [locomotive.engineNumber, locomotive.engineType, locomotive.today, locomotive.shed, locomotive.manufacturer, locomotive.topSpeed, locomotive.manufacturedDay, locomotive.state], function (err, count) {
            if (err) {
                callback(err, null);
            } else {
                db.query("SHOW TABLE STATUS LIKE 'locomotive'", callback);
            }
        })
    },
    deleteLocomotive: function (id, callback) {
        return db.query("delete from locomotive where EngineNumber=?", [id], callback);
    },
    updateLocomotive: function (id, locomotive, callback) {
        return db.query("update locomotive set name=?, state=? where id=?", [locomotive.name, locomotive.state, id], callback);
    },
}

module.exports=Locomotive;