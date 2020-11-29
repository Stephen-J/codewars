// https://www.codewars.com/kata/554b4ac871d6813a03000035

function highAndLow(numbers){
    let sortedNumbers = numbers.split(' ').map((n) => parseInt(n.trim())).sort((a,b) => a - b);
    return [sortedNumbers[sortedNumbers.length - 1],sortedNumbers[0]].map((n) => n.toString()).join(" ");
}


console.log(highAndLow("1 2 3 4 5"));
console.log(highAndLow("1 2 -3 5 4"));
console.log(highAndLow("4 5 29 54 4 0 -214 542 -64 1 -3 6 -6"));
console.log([1 ,-9]);