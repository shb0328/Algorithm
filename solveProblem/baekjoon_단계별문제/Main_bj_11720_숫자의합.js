const fs = require('fs');
const input = fs.readFileSync('/dev/stdin','utf8').split('\n');
const sum = input[1].split('').reduce((result,v)=>result+ (+v),0);
console.log(sum);