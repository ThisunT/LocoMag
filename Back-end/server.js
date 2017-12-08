/**
 * Created by Thisun Pathirage on 8/31/2017.
 */
var express = require('express');
var bodyParser = require('body-parser');
//var authenticator = require('./middleware/authenticator')

var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));
var port = 3000;

var router = express.Router();


var LocomotiveRoute = require("./routes/LocomotiveRoute");
router.use('/locomotive', LocomotiveRoute);

var UserRoute = require("./routes/UserRoute");
router.use('/user', UserRoute);

app.use('/api', router);

app.listen(port);
console.log('Server is up on port ' + port);