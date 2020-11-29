// https://www.codewars.com/kata/529bf0e9bdf7657179000008

function validSolution(board){
    let check = (arr) => {
        let tmp = arr.map((item) => item);
        tmp.sort();
        return tmp.join('') == '123456789';};

    let rowsCorrect  = board.reduce((isCorrect,row) => !isCorrect ?  isCorrect: check(row),true);
    let columnsCorrect = true;
    if(rowsCorrect){
        for(let i = 0 ; i < 9 ; i++){
            let arr = [];
            for(let j = 0 ; j < 9 ; j++){
                arr.push(board[j][i]);
            }
            if(columnsCorrect) columnsCorrect = check(arr);
        }
    }
    let blocksCorrect = true;
    if(columnsCorrect){
        for(let i = 0 ; i < 9 ; i += 3){
            for(let j = 0 ; j < 9; j += 3){
                let arr = [];
                for(let k = 0 ; k < 3 ; k++){
                    for(let l = 0 ; l < 3 ; l++){
                        arr.push(board[i + k][j + l]);
                    }
                }
                if(blocksCorrect) blocksCorrect = check(arr);
            }
        }
    }
    return rowsCorrect && columnsCorrect && blocksCorrect;
}

console.log(validSolution([
    [5, 3, 4, 6, 7, 8, 9, 1, 2],
    [6, 7, 2, 1, 9, 5, 3, 4, 8],
    [1, 9, 8, 3, 4, 2, 5, 6, 7],
    [8, 5, 9, 7, 6, 1, 4, 2, 3],
    [4, 2, 6, 8, 5, 3, 7, 9, 1],
    [7, 1, 3, 9, 2, 4, 8, 5, 6],
    [9, 6, 1, 5, 3, 7, 2, 8, 4],
    [2, 8, 7, 4, 1, 9, 6, 3, 5],
    [3, 4, 5, 2, 8, 6, 1, 7, 9]
  ])); // => true

 console.log(validSolution([
    [5, 3, 4, 6, 7, 8, 9, 1, 2], 
    [6, 7, 2, 1, 9, 0, 3, 4, 8],
    [1, 0, 0, 3, 4, 2, 5, 6, 0],
    [8, 5, 9, 7, 6, 1, 0, 2, 0],
    [4, 2, 6, 8, 5, 3, 7, 9, 1],
    [7, 1, 3, 9, 2, 4, 8, 5, 6],
    [9, 0, 1, 5, 3, 7, 2, 1, 4],
    [2, 8, 7, 4, 1, 9, 6, 3, 5],
    [3, 0, 0, 4, 8, 1, 1, 7, 9]
  ])); // => false

 console.log(validSolution([
  [1, 2, 3, 4, 5, 6, 7, 8, 9],
  [1, 2, 3, 4, 5, 6, 7, 8, 9],
  [1, 2, 3, 4, 5, 6, 7, 8, 9],
  [1, 2, 3, 4, 5, 6, 7, 8, 9],
  [1, 2, 3, 4, 5, 6, 7, 8, 9],
  [1, 2, 3, 4, 5, 6, 7, 8, 9],
  [1, 2, 3, 4, 5, 6, 7, 8, 9],
  [1, 2, 3, 4, 5, 6, 7, 8, 9],
  [1, 2, 3, 4, 5, 6, 7, 8, 9]])); //false

console.log(validSolution([
    [1, 2, 3, 4, 5, 6, 7, 8, 9],
    [2, 3, 1, 5, 6, 4, 8, 9, 7],
    [3, 1, 2, 6, 4, 5, 9, 7, 8],
    [4, 5, 6, 7, 8, 9, 1, 2, 3],
    [5, 6, 4, 8, 9, 7, 2, 3, 1],
    [6, 4, 5, 9, 7, 8, 3, 1, 2],
    [7, 8, 9, 1, 2, 3, 4, 5, 6],
    [8, 9, 7, 2, 3, 1, 5, 6, 4],
    [9, 7, 8, 3, 1, 2, 6, 4, 5]])); //false

console.log(validSolution([
    [5, 3, 4, 6, 7, 8, 9, 1, 2],
    [6, 7, 2, 1, 9, 5, 3, 4, 8],
    [1, 9, 8, 3, 4, 2, 5, 6, 7],
    [8, 5, 9, 7, 6, 1, 4, 2, 3],
    [4, 2, 6, 8, 5, 3, 7, 9, 1],
    [7, 1, 3, 9, 2, 4, 8, 5, 6],
    [9, 6, 1, 5, 3, 7, 2, 8, 4],
    [2, 8, 7, 4, 1, 9, 6, 3, 5],
    [3, 4, 5, 2, 8, 6, 1, 7, 9]])); //true

console.log(validSolution([
    [8, 2, 6, 3, 4, 7, 5, 9, 1],
    [7, 3, 5, 8, 1, 9, 6, 4, 2],
    [1, 9, 4, 2, 6, 5, 8, 7, 3],
    [3, 1, 7, 5, 8, 4, 2, 6, 9],
    [6, 5, 9, 1, 7, 2, 4, 3, 8],
    [4, 8, 2, 9, 3, 6, 7, 1, 5],
    [9, 4, 8, 7, 5, 1, 3, 2, 6],
    [5, 6, 1, 4, 2, 3, 9, 8, 7],
    [2, 7, 3, 6, 9, 8, 1, 5, 4]])); //true