//https://www.codewars.com/kata/55f3da49e83ca1ddae0000ad

fn tank_vol(h: i32, d: i32, vt: i32) -> i32 {
    let l = vt as f64 / (std::f64::consts::PI * (d as f64/2.0).powf(2.0));
    let r = d as f64 / 2.0;
    let h1 = h as f64;
    (l * (r.powf(2.0) * ((r - h1) / r).acos() - (r - h1) * (2.0 * r * h1 - h1.powf(2.0)).sqrt())) as i32
}


fn main(){
    assert_eq!(tank_vol(40, 120, 3500), 1021);
    assert_eq!(tank_vol(2, 8, 5026), 982);
    assert_eq!(tank_vol(5, 7, 3848), 2940);
    assert_eq!(tank_vol(5, 7, 3848), 2940);
    assert_eq!(tank_vol(2, 7, 3848), 907);
    assert_eq!(tank_vol(4, 9, 6361), 2731);
}