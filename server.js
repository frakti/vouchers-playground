'use strict';

var express = require('express');
var app = express();
var voucherifyClient = require("voucherify");

var voucherify = voucherifyClient({
    applicationId: "c70a6f00-cf91-4756-9df5-47628850002b",
    clientSecretKey: "3266b9f8-e246-4f79-bdf0-833929b1380c"
});


app.use(express.static('public'));

app.get('/buy/:code', function (req, res) {

  voucherify.redeem(req.params.code).
  then(function () {
    return req.sendStatus(200);
  })
  .catch(function () {
    return res.sendStatus(410);
  })
});


var server = app.listen(8082, function () {
  var host = server.address().address;
  var port = server.address().port;

  console.log('Listening at http://%s:%s', host, port);
});