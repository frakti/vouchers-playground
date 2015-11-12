'use strict';

require('babel-core/register');

console.time('babel_transpile_time');
require('./server');
console.timeEnd('babel_transpile_time');
