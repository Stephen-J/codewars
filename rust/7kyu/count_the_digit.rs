//https://www.codewars.com/kata/566fc12495810954b1000030
fn nb_dig(n: i32, d: i32) -> i32 {
    let digit = d.to_string().chars().next().unwrap();
    (1..=n).fold(0,|count,n| count + (n * n).to_string().chars().filter(|i| *i == digit).collect::<Vec<char>>().len() as i32)
}

fn main(){
    println!("{}",nb_dig(10,1)); // 4
    println!("{}",nb_dig(25,1)); // 11
}