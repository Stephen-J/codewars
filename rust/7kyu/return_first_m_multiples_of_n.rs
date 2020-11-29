// https://www.codewars.com/kata/593c9175933500f33400003e

fn multiples(m: i32, n: f64) -> Vec<f64> {
    (1..=m).map(|i| i as f64 * n).collect()
}


fn main(){
    assert_eq!(multiples(3, 5.0), vec![5.0, 10.0, 15.0]);
    assert_eq!(multiples(5, -1.0), vec![-1.0, -2.0, -3.0, -4.0, -5.0]);
    assert_eq!(multiples(1, 3.14), vec![3.14]);
}