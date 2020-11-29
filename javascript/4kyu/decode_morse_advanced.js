// https://www.codewars.com/kata/54b72c16cd7f5154e9000457

const MORSE_CODE = {
    '-.-.--': '!',
    '.-..-.': '"',
    '...-..-': '$',
    '.-...': '&',
    '.----.': '\'',
    '-.--.': '(',
    '-.--.-': ')',
    '.-.-.': '+',
    '--..--': ',',
    '-....-': '-',
    '.-.-.-': '.',
    '-..-.': '/',
    '-----': '0',
    '.----': '1',
    '..---': '2',
    '...--': '3',
    '....-': '4',
    '.....': '5',
    '-....': '6',
    '--...': '7',
    '---..': '8',
    '----.': '9',
    '---...': ':',
    '-.-.-.': ';',
    '-...-': '=',
    '..--..': '?',
    '.--.-.': '@',
    '.-': 'A',
    '-...': 'B',
    '-.-.': 'C',
    '-..': 'D',
    '.': 'E',
    '..-.': 'F',
    '--.': 'G',
    '....': 'H',
    '..': 'I',
    '.---': 'J',
    '-.-': 'K',
    '.-..': 'L',
    '--': 'M',
    '-.': 'N',
    '---': 'O',
    '.--.': 'P',
    '--.-': 'Q',
    '.-.': 'R',
    '...': 'S',
    '-': 'T',
    '..-': 'U',
    '...-': 'V',
    '.--': 'W',
    '-..-': 'X',
    '-.--': 'Y',
    '--..': 'Z',
    '..--.-': '_',
    '...---...': 'SOS' };
//1 connected
//0 not connected
//"Dot" – is 1 time unit long.
//"Dash" – is 3 time units long.
//Pause between dots and dashes in a character – is 1 time unit long.
//Pause between characters inside a word – is 3 time units long.
//Pause between words – is 7 time units long.

var decodeBits = function(bits){
    let reg = /0+|1+/g;
    let matchAll = (str) =>{
         let results = [];
         let done = false;
         while(!done){
             let match = reg.exec(str);
             match != null ? results.push(match) : done = true;
         }
         return results;
     };
     let cleaned = bits.slice(bits.indexOf('1'),bits.lastIndexOf('1') + 1);
     let onOff = Array.from(matchAll(cleaned)).map((match) => match[0]);
     let times = onOff.reduce((t,item) => {t.push(item.length); return t;},[]);
     let timeUnit = Math.min.apply(Math,times);
     let translated = onOff.map((item) => {
         let morse = '';
         switch(item.length / timeUnit){
             case 1:
                 item[0] == '1' ? morse = '.' : morse = '';
                 break;
             case 3:
                 item[0] == '1' ? morse = '-' : morse = ' ';
                 break;
             case 7:
                 morse = '   ';
                 break;
             default:
                 morse = '';
         }
         return morse;
     });
     return translated.join('');
 }
     
 var decodeMorse = function(morseCode){
     return morseCode.split('   ')
         .map((word) => word.split(' '))
         .map((word) => word.map((letter) => MORSE_CODE[letter]).join(''))
         .join(' ')
         .trim();
 }


'.... . -.--   .--- ..- -.. .'
console.log(decodeMorse(decodeBits('011001100110011000000110000001111110011001111110011111100000000000000110011111100111111001111110000001100110011111100000011111100110011000000110')));
// 'HEY JUDE'
