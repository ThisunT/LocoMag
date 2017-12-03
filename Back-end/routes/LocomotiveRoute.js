/**
 * Created by Thisun Pathirage on 8/31/2017.
 */
var express = require('express')
var router = express.Router()
var Locomotive=require('../models/Locomotive')

router.get('/:id?',function(req, res){
    if(req.params.id){
        Locomotive.getLocomotiveById(req.params.id, function(err, rows){
            if(err){
                res.status(400)
                res.json(err)
            }else{
                res.json(rows)
            }
        })
    }else{
        Locomotive.getAllLocomotives(function(err, rows){
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
    Locomotive.addLocomotive(req.body, function(err, count){
        if(err){
            res.status(400)
            res.json(err)
        }else{
            res.json(count)
        }
    })
})

router.delete('/:id',function(req, res){
    Locomotive.deleteLocomotive(req.params.id, function(err, count){
        if(err){
            res.status(400)
            res.json(err)
        }else{
            res.json(count)
        }
    })
})

router.post('/:id', function(req, res){
    Locomotive.updateLocomotive(req.params.id , req.body , function(err, rows){
        if(err){
            res.status(400)
            res.json(err)
        }else{
            res.json(rows);
        }
    });
});

module.exports=router;