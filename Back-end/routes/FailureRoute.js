/**
 * Created by Thisun Pathirage on 12/4/2017.
 */
var express = require('express')
var router = express.Router()
var Failure=require('../models/Failure')

router.get('/:id?',function(req, res){
    if(req.params.id){
        Failure.getFailureById(req.params.id, function(err, rows){
            if(err){
                res.status(400)
                res.json(err)
            }else{
                res.json(rows)
            }
        })
    }else{
        Failure.getAllFailures(function(err, rows){
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
    Failure.addFailure(req.body, function(err, count){
        if(err){
            res.status(400)
            res.json(err)
        }else{
            res.json(count)
        }
    })
})

router.delete('/:id',function(req, res){
    Failure.deleteFailure(req.params.id, function(err, count){
        if(err){
            res.status(400)
            res.json(err)
        }else{
            res.json(count)
        }
    })
})



module.exports=router;