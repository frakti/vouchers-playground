Vouchers Playground
===================

The goal of this project is to play around with [voucherify.io](http://voucherify.io) SaaS for campaign and vouchers management using SDKs they provide.

The platform provides test campaign with voucher to be used without any limits.

The sandbox
-----------

Repository has node.js backend which uses [Voucherify NodeJS SDK](https://voucherify.readme.io/docs/nodejs-tutorial) to redeem a voucher. Backend serves also a static page (`/public`) on which you can validate voucher and use some utils on your frontend using [Voucherify.js SDK](https://voucherify.readme.io/docs/voucherifyjs).
In `java-app` dir you can find small static main Java app showing how to redeem vouchers in Java-based backend using [voucherify-java-sdk](http://repo1.maven.org/maven2/pl/rspective/voucherify/client/voucherify-java-sdk/1.9.1/). They provide also (Andorid SDK)[https://voucherify.readme.io/docs/android-tutorial] which contains a nice demo app, recommend o check it out!


How to run
----------

### Web Page and nodejs backend

- Pre-requisites:

Node.js - recommend to use [nvm](https://github.com/creationix/nvm)

- Install dependencies:

`npm install`

- Run the app:

`npm start`

It will start a HTTP server on port 8082.
Open in a browser http://localhost:8082.

### Java app

- Pre-requisites: Java 8

- Run:
  - go to `./java-app`
  - Invoke `./gradlew run`