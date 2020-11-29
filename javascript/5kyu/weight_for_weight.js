// https://www.codewars.com/kata/55c6126177c9441a570000cc
function orderWeight(strng) {
    return strng.split(' ').sort((a,b) => {
        weightedA = Array.from(a).map((i) => parseInt(i)).reduce((a,b) => a + b);
        weightedB = Array.from(b).map((i) => parseInt(i)).reduce((a,b) => a + b);
        return weightedA != weightedB ? weightedA - weightedB : a.localeCompare(b);
    }).join(' ');
}

console.log(orderWeight("103 123 4444 99 2000") == "2000 103 123 4444 99");
console.log(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123") == "11 11 2000 10003 22 123 1234000 44444444 9999");