// https://www.codewars.com/kata/551dc350bf4e526099000ae5

const songDecoder = (song) => song.split(/(?:WUB)*/).join(' ').trim();
 



console.log(songDecoder("AWUBBWUBC")); // "A B C"
console.log(songDecoder("AWUBWUBWUBBWUBWUBWUBC")); // "A B C"
console.log(songDecoder("WUBAWUBBWUBCWUB")); //  "A B C"