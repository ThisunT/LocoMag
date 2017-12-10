/**
 * Created by Thisun Pathirage on 12/10/2017.
 */
var express = require('express')
var router = express.Router()
var Sync=require('../models/Sync')

router.get('/:id?',function(req, res){
    if(req.params.id){
        Sync.getSyncById(req.params.id, function(err, rows){
            if(err){
                res.status(400)
                res.json(err)
            }else{
                res.json(rows)
            }
        })
    }else{
        Sync.getStateSync(function(err, rows){
            if(err){
                res.status(400)
                res.json(err)
            }else{
                res.json(rows)
            }
        })
    }
})


module.exports=router;