// https://www.codewars.com/kata/555615a77ebc7c2c8a0000b8


function tickets(peopleInLine){
    let ticket_price = 25;
    let change = {25:0,50:0,100:0};
    let make_change = true;
    for(i = 0 ; i < peopleInLine.length ; i++){
        switch(peopleInLine[i]){
            case 50 :
                change[25] >= 1 ? change[25]-- : make_change = false;
                break;
            case 100 :
                if(change[50] >= 1 && change[25] >= 1){
                    change[50]--;
                    change[25] -= 1;
                }else if(change[25] >= 3){
                    change[25] -= 3;
                }else{
                    make_change = false;
                }
                break;
        }
        if (!make_change) break;
        change[peopleInLine[i].toString()]++;
    }
    return make_change ? 'YES' : 'NO';
}


console.log(tickets([25, 25, 50, 50])); // Yes
console.log(tickets([25, 100])); // No