/**
 * Created by Thisun Pathirage on 8/31/2017.
 */
var mysql=require('mysql');

var connection=mysql.createPool({
    host:'localhost',
    user:'root',
    password:'',
    dateStrings:true,
    database:'database'
});

module.exports=connection;