
var express = require('express')
var router = express.Router()
var Maintenance=require('../models/Maintenance')

router.get('/:id?',function(req, res){
    if(req.params.id){
        Maintenance.getWIPById(req.params.id, function(err, rows){
            if(err){
                res.status(400)
                res.json(err)
            }else{
                res.json(rows)
            }
        })
    }else{
        Maintenance.getAllWIP(function(err, rows){
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
    Maintenance.addWIP(req.body, function(err, count){
        if(err){
            res.status(400)
            res.json(err)
        }else{
            res.json(count)
        }
    })
})

router.delete('/:id',function(req, res){
    Maintenance.deleteWIP(req.params.id, function(err, count){
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