// https://www.codewars.com/kata/5648b12ce68d9daa6b000099


var number = (busStops) => busStops.reduce((accum,vals) => accum + vals[0] - vals[1],0);


console.log(number([[10,0],[3,5],[5,8]])); //5
console.log(number([[3,0],[9,1],[4,10],[12,2],[6,1],[7,10]])); //17
console.log(number([[3,0],[9,1],[4,8],[12,2],[6,1],[7,8]])); //21