// https://www.codewars.com/kata/525c65e51bf619685c000059

function cakes(recipe, available) {
    let numItems = 0;
    let recipeItems = Object.entries(recipe);
    let outOfStuff = false;
    while(!outOfStuff){
        for(let recipeItem of recipeItems){
            available[recipeItem[0]] != undefined ? available[recipeItem[0]] -= recipeItem[1] : outOfStuff = true;
            if(available[recipeItem[0]] < 0) outOfStuff = true;
        }
        if(outOfStuff) {break} else {numItems++};
    }
    return numItems;
}

recipe = {flour: 500, sugar: 200, eggs: 1};
available = {flour: 1200, sugar: 1200, eggs: 5, milk: 200};
console.log(cakes(recipe, available)); // 2

recipe = {apples: 3, flour: 300, sugar: 150, milk: 100, oil: 100};
available = {sugar: 500, flour: 2000, milk: 2000};
console.log(cakes(recipe, available)); // 0;

console.log({a:'1'}['b']);



console.log(r);