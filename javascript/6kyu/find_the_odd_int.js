// https://www.codewars.com/kata/54da5a58ea159efa38000836
function findOdd(A) {
    let counts =  A.reduce((c,n) => {
        c[n] == undefined ? c[n] = 1 : c[n]++;
        return c;},{});
    return Array.from(Object.entries(counts)).reduce((odd,[num,count]) => count % 2 == 0 ? odd : parseInt(num),0);
}


console.log(findOdd([20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5])); //  5);
console.log(findOdd([1,1,2,-2,5,2,4,4,-1,-2,5])); //, -1);
console.log(findOdd([20,1,1,2,2,3,3,5,5,4,20,4,5])); //, 5);
console.log(findOdd([10])); //, 10);
console.log(findOdd([1,1,1,1,1,1,10,1,1,1,1])); //, 10);
console.log(findOdd([5,4,3,2,1,5,4,3,2,10,10])); //, 1);