'use strict';

const express = require('express');
const app = express();
app.use(express.static('public'));
app.use('/babel', express.static('node_modules/babel-browser'));

const voucherifyClient = require("voucherify");
const voucherify = voucherifyClient({
    applicationId: "c70a6f00-cf91-4756-9df5-47628850002b",
    clientSecretKey: "3266b9f8-e246-4f79-bdf0-833929b1380c"
});

app.get('/buy/:code', function (req, res) {

  voucherify.redeem(req.params.code)
    .then(() => req.sendStatus(200))
    .catch(() => res.sendStatus(410))
});

const server = app.listen(8082, function () {
  let host = server.address().address;
  let port = server.address().port;

  console.log('Listening at http://%s:%s', host, port);
});