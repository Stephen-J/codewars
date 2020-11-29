// https://www.codewars.com/kata/523f5d21c841566fde000009

fn array_diff<T: PartialEq>(a: Vec<T>, b: Vec<T>) -> Vec<T> {
    a.into_iter().filter(|n| !b.contains(n)).collect()
}


fn main(){
    println!("{:?}",array_diff(vec![1,2],vec![1])); // [2]
    println!("{:?}",array_diff(vec![1,2,2,2,3],vec![2])); // [1,3]
}