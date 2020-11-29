// https://www.codewars.com/kata/53f40dff5f9d31b813000774

//Recover a secret string from random triplets
var recoverSecret = function(triplets) {
    let letters = Array.from(triplets.reduce((s,triplet) => triplet.reduce((a,letter) => a.add(letter),s),new Set()));
    console.log(letters);
    let tmp = [];
    for(let i = 0 ; i < triplets.length ; i++){
        let first =  tmp.indexOf(triplets[i][0]);
        let second = tmp.indexOf(triplets[i][1]);
        let third = tmp.indexOf(triplets[i][2]);
        if(first == -1 && second == -1 && third == -1){
            console.log('11');
            console.log(triplets[i]);
            tmp = tmp.concat(triplets[i]);
            console.log(tmp);
        }else if(third - first == 1){
            console.log('aaaaaa');
            tmp = [tmp[0],triplets[i][1]].concat(tmp.slice(1));
        }
        
    }
    console.log(tmp);
    /*let order = letters.reduce((o,letter)=>{
        let relevantTriplets = triplets.reduce((a,t) => {
            if(t.indexOf(letter) != -1) a.push(t);
            return a;},[]);
        o[letter] = relevantTriplets.reduce((accum,triplet) =>{
            return accum.concat(triplet.slice(triplet.indexOf(letter) + 1,3));
        },[]);
        return o;
    },{});
    console.log(order);
    let tmp = letters.map((i) => i);
    for(let i = 0; i < letters.length ; i++){
        tmp.sort((a,b)=>{
            if(a == letters[i]){
                if(order[a].indexOf(b) == -1) return 1;
            }else{
                return -1;
            }
        });
    }*/
    //console.log(tmp);
    //console.log(letters.join());
    //for(let i = 0 ; i < letters.length;i++){
    //    for(let j = 0 ; j < triplets.length ; j++){
    //        letters.sort((a,b) => {
    //            if(triplets[j][0] == a) return a.localeCompare(b);
    //            return 0;
    //        });
    //    }

    //}
    //console.log(letters);
}

secret1 = "whatisup"
triplets1 = [
  ['t','u','p'],
  ['w','h','i'],
  ['t','s','u'],
  ['a','t','s'],
  ['h','a','p'],
  ['t','i','s'],
  ['w','h','s']
]

console.log(recoverSecret(triplets1));