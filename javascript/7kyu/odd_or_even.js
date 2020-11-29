// https://www.codewars.com/kata/5949481f86420f59480000e7

function oddOrEven(array) {
    array.push(0);
    return array.reduce((a,b) => a + b) % 2 == 0 ? 'even' : 'odd';
 }


 console.log(oddOrEven([0])); //even
 console.log(oddOrEven([0,1,4])); //odd
 console.log(oddOrEven([0,-1,-5])); //even
 console.log(oddOrEven([])); //even