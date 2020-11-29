// https://www.codewars.com/kata/5899aa695401a83a5c0000c4
fn square_area_to_circle(size:f64) -> f64 {
    std::f64::consts::PI * (size.sqrt() / 2.0).powf(2.0)
}

fn main(){
    print!("{}",(square_area_to_circle(9.0))); // 7.06
}