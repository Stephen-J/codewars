// https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec

function persistence(num) {
    if(num < 10) return 0;
    let tmp = Array.from(num.toString()).map((n) => parseInt(n));
    let val = tmp.reduce((a,b) => a * b);
    let mp = 1;
    while(val >= 10){
        tmp = Array.from(val.toString()).map((n) => parseInt(n));
        val = tmp.reduce((a,b) => a * b);
        mp++;
    }
    return mp;
}


console.log(persistence(39) == 3);
console.log(persistence(4) == 0);
console.log(persistence(25) == 2);
console.log(persistence(999) == 4);


console.log(persistence(883076)); 