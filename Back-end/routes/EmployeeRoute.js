/**
 * Created by Thisun Pathirage on 12/5/2017.
 */
var express = require('express')
var router = express.Router()
var Employee=require('../models/Employee')

router.get('/:id?',function(req, res){
    if(req.params.id){
        Employee.getEmployeeById(req.params.id, function(err, rows){
            if(err){
                res.status(400)
                res.json(err)
            }else{
                res.json(rows)
            }
        })
    }else{
        Employee.getAllEmployees(function(err, rows){
            if(err){
                res.status(400)
                res.json(err)
            }else{
                res.json(rows)
            }
        })
    }
})

router.post('/', function(req, res){
    Employee.addEmployee(req.body, function(err, count){
        if(err){
            res.status(400)
            res.json(err)
        }else{
            res.json(count)
        }
    })
})

router.delete('/:id',function(req, res){
    Employee.deleteEmployee(req.params.id, function(err, count){
        if(err){
            res.status(400)
            res.json(err)
        }else{
            res.json(count)
        }
    })
})

/*router.post('/:id', function(req, res){
 Locomotive.updateLocomotive(req.params.id , req.body , function(err, rows){
 if(err){
 res.status(400)
 res.json(err)
 }else{
 res.json(rows);
 }
 });
 });*/

module.exports=router;