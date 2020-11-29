// https://www.codewars.com/kata/5848565e273af816fb000449

fn encrypt_this(text: &str) -> String {
    text.split(' ').into_iter().map(|word|{
        let mut encrypted : Vec<String> = vec![];
        encrypted.push(word[0..1].as_bytes().first().unwrap().to_string());
        if word.len() > 2 {
            encrypted.push(word[word.len() - 1 .. word.len()].to_string());
            encrypted.push(word[2 .. word.len() - 1].to_string());
            encrypted.push(word[1 .. 2].to_string());
        } else if word.len() == 2{
            encrypted.push(word[1 .. 2].to_string());
        }
        return encrypted.join("");
    }).collect::<Vec<String>>().join(" ")
}

fn main(){
    println!("A => {} should be => {}",encrypt_this(&"A"),"65".to_string());
    println!("A wise old owl lived in an oak => {} should be => {}",encrypt_this(&"A wise old owl lived in an oak"), "65 119esi 111dl 111lw 108dvei 105n 97n 111ka".to_string());
    println!("The more he saw the less he spoke => {} should be => {}",encrypt_this(&"The more he saw the less he spoke"),"84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp".to_string());
    println!("The less he spoke the more he heard => {} should be => {}",encrypt_this(&"The less he spoke the more he heard"), "84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare".to_string());
    println!("Why can we not all be like that wise old bird => {} should be => {}",encrypt_this(&"Why can we not all be like that wise old bird"),"87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri".to_string());
    println!("Thank you Piotr for all your help => {} should be => {}",encrypt_this(&"Thank you Piotr for all your help"),"84kanh 121uo 80roti 102ro 97ll 121ruo 104ple".to_string());
}