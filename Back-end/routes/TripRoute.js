/**
 * Created by Thisun Pathirage on 12/5/2017.
 */
var express = require('express')
var router = express.Router()
var Trip=require('../models/Trip')

router.get('/:id?',function(req, res){
    if(req.params.id){
        Trip.getTripById(req.params.id, function(err, rows){
            if(err){
                res.status(400)
                res.json(err)
            }else{
                res.json(rows)
            }
        })
    }else{
        Trip.getAllTrips(function(err, rows){
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
    Trip.addTrip(req.body, function(err, count){
        if(err){
            res.status(400)
            res.json(err)
        }else{
            res.json(count)
        }
    })
})

router.delete('/:id',function(req, res){
    Trip.deleteTrip(req.params.id, function(err, count){
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