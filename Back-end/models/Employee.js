/**
 * Created by Thisun Pathirage on 12/5/2017.
 */
var db = require('../database/mysqlConnection');

var Employee = {
    getAllEmployees: function (callback) {
        return db.query("select * from employee", callback);
    },
    getEmployeeById: function (id, callback) {
        if(id=="id"){
            return db.query("select employee_ID from employee", callback);
        }else{
            return db.query("select * from employee where employee_ID=?", [id], callback);
        }

    },
    addEmployee: function (employee, callback) {
        return db.query("insert into employee(employee_ID,profession,name,nic,age,contact_number,email,address) values(?,?,?,?,?,?,?,?)", [employee.employeeId, employee.profession, employee.name, employee.nic, employee.age, employee.contactNumber, employee.email, employee.address], function (err, count) {
            if (err) {
                callback(err, null);
            } else {
                db.query("SHOW TABLE STATUS LIKE 'trip'", callback);
            }
        })
    },
    deleteEmployee: function (id, callback) {
        return db.query("delete from employee where employee_ID=?", [id], callback);
    },
}

module.exports=Employee;