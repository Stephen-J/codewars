// https://www.codewars.com/kata/5503013e34137eeeaa001648
function diamond(n){
    if(n <= 0 || n % 2 == 0) return null;
    let center = Math.ceil(n/2);
    let centerStars = 1 + 2 * (center - 1);
    let arr = [];
    for(row = 0 ; row < n ; row++){
        let numStars = row < center ? 1 + 2 * row : centerStars - (2 * (row - (center - 1)));
        let numSpaces = centerStars - numStars; 
        for(i = 0 ; i < numSpaces / 2 ; i++){
            arr.push(' ');
        }
        for(col = 0 ; col < numStars ; col++){
            arr.push('*');
        }
        arr.push('\n');
    }
    return arr.join('');
  }


  console.log(diamond(1) == "*\n"); // "*\n")
  console.log(diamond(3) == " *\n***\n *\n"); //" *\n***\n *\n")
  console.log(diamond(5) == "  *\n ***\n*****\n ***\n  *\n"); //"  *\n ***\n*****\n ***\n  *\n")
  console.log(diamond(2) == null); //null)
  console.log(diamond(-3) == null),// null)
  console.log(diamond(0) == null); //null
  console.log(diamond(11));