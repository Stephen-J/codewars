// https://www.codewars.com/kata/550498447451fbbd7600041c

fn comp(a: Vec<i64>,b: Vec<i64>) -> bool {
    if a.len() != b.len(){
        return false;
    }
    let mut a1 : Vec<i64> = a.iter().map(|i| i.abs()).collect();
    let mut a2 : Vec<i64> = b.iter().map(|i| i.abs()).collect(); 
    a1.sort();
    a2.sort();
    match a1.iter().zip(a2.iter()).find(|item| *item.1 != item.0 * item.0){
        None => true,
        _ => false
    }
}


fn main(){
    let a1 = vec![121, 144, 19, 161, 19, 144, 19, 11];
    let a2 = vec![11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19];
    println!("Got -> {} should be -> {}",comp(a1,a2),true);
    let a1 = vec![121, 144, 19, 161, 19, 144, 19, 11];
    let a2 = vec![11*21, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19];
    println!("Got -> {} should be -> {}",comp(a1,a2),false);
    let a1 = vec![-161, -144, -144, -121, -11, 19, 19, 19];
    let a2 = vec![121, 361, 361, 361, 14641, 20736, 20736, 25921];
    println!("Got -> {} should be -> {}",comp(a1,a2),true);
}