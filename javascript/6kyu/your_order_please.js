// https://www.codewars.com/kata/55c45be3b2079eccff00010f
function order(words){
    return words.split(' ').map((word) => [parseInt(word.match(/\d*/g).join('')),word]).sort((a,b) => a[0] - b[0]).map((item) => item[1]).join(' ');
}



console.log(order("is2 Thi1s T4est 3a")); //"Thi1s is2 3a T4est"
console.log(order("4of Fo1r pe6ople g3ood th5e the2")); //"Fo1r the2 g3ood 4of th5e pe6ople"
console.log(order("")); //""