// https://www.codewars.com/kata/57eb8fcdf670e99
use std::cmp::Ordering;

fn high(input: &str) -> &str {
    let mut word_lengths = input.split(' ').enumerate().map(|indexed_word|{
        (indexed_word.0,indexed_word.1.as_bytes().iter().fold(0,|accum,i| accum + (*i as u64) - 96),indexed_word.1)
    }).collect::<Vec<(usize,u64,&str)>>();
    word_lengths.sort_by(|a,b| match a.1.cmp(&b.1){
        Ordering::Equal => match a.0.cmp(&b.0){
            Ordering::Less => Ordering::Greater,
            Ordering::Greater => Ordering::Less,
            _ => Ordering::Equal
        },
        _ => a.1.cmp(&b.1)
    });
    word_lengths.last().unwrap().2
}


fn main(){
    assert_eq!(high("man i need a taxi up to ubud"), "taxi");               
    assert_eq!(high("what time are we climbing up the volcano"), "volcano");
    assert_eq!(high("take me to semynak"), "semynak");                      
    assert_eq!(high("massage yes massage yes massage"), "massage");         
    assert_eq!(high("take two bintang and a dance please"), "bintang");     
    assert_eq!(high("aaa b"), "aaa");                                       
    assert_eq!(high(""), "");
    assert_eq!(high("aaa aaa aaa aaa"), "aaa");
}