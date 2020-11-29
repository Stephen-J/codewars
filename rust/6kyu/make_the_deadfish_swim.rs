//https://www.codewars.com/kata/51e0007c1f9378fa810002a9

//i increments the value (initially 0)
//d decrements the value
//s squares the value
//o outputs the value into the return array
fn parse(code: &str) -> Vec<i32> {
    let mut output : Vec<i32> = Vec::new();
    let mut value : i32 = 0;
    for instruction in code.chars() {
        match instruction {
            'i' => value += 1,
            'd' => value -= 1,
            's' => value *= value,
            'o' => output.push(value),
            _ => ()
        }
    } 
    return output;
}

fn main(){
    println!("iiiisdoso => {:?} should be => {:?}",parse("iiisdoso"),vec![8,64]);
    println!("iiisdosodddddiso => {:?} should be => {:?}",parse("iiisdosodddddiso"),vec![8, 64, 3600]);
}