// https://www.codewars.com/kata/5842df8ccbd22792a4000245
function expandedForm(num) {
    return num.toString()
              .split('')
              .reverse()
              .map((entry,index) => {
                  let arr = [];
                  arr[0] = entry;
                  for(i = 1 ; i <= index ; i ++){
                      arr[i] = 0;
                  }
                  return arr.join('');
              })
              .filter((item) => item[0] != '0')
              .reverse()
              .join(' + ');
}


  console.log(expandedForm(12)); //  '10 + 2'   
  console.log(expandedForm(42)); // '40 + 2'
  console.log(expandedForm(70304)); // '70000 + 300 + 4'