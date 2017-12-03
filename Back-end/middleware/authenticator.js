/**
 * Created by Thisun Pathirage on 9/1/2017.
 */
var authenticator = function(object, name){
    return function (req, res, next) {
        //console.log(req.headers);
        //console.log(req.url);
        console.log(req.method)
        if(req.headers.sessionId == '0001' || true){
            next()
        }else{
            //res.json({err:"asd"})
            res.status(500).json({ error: 'no acess' });		}

    }
}

module.exports = authenticator

