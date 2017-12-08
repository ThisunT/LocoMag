/**
 * Created by Thisun Pathirage on 12/5/2017.
 */
var express = require('express')
var router = express.Router()
var User=require('../models/User')

router.get('/:username?',function(req, res){
    if(req.params.username){
        User.getUserByUsername(req.params.username, function(err, rows){
            if(err){
                res.status(400)
                res.json(err)
            }else{
                res.json(rows)
            }
        })
    }
    else{
        User.getAllUsers(function(err, rows){
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
    User.addUser(req.body, function(err, count){
        if(err){
            res.status(400)
            res.json(err)
        }else{
            res.json(count)
        }
    })
})

router.delete('/:employee_ID',function(req, res){
    User.deleteUser(req.params.employee_ID, function(err, count){
        if(err){
            res.status(400)
            res.json(err)
        }else{
            res.json(count)
        }
    })
})



module.exports=router;