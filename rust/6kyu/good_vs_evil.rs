// https://www.codewars.com/kata/52761ee4cffbc69732000738


fn good_vs_evil(good: &str, evil: &str) -> String {
    let good_points : Vec<u32> = vec![1,2,3,3,4,10];
    let evil_points : Vec<u32> = vec![1,2,2,2,3,5,10];
    let good_wins : String = String::from("Battle Result: Good triumphs over Evil");
    let evil_wins : String = String::from("Battle Result: Evil eradicates all trace of Good");
    let tie : String = String::from("Battle Result: No victor on this battle field");
    let good_score : u32 = good.split(' ').enumerate().fold(0,|mut score,item|{
        let points : u32 = item.1.parse::<u32>().unwrap();
        score += good_points[item.0] * points;
        score
    });
    let evil_score : u32 = evil.split(' ').enumerate().fold(0,|mut score,item|{
        let points : u32 = item.1.parse::<u32>().unwrap();
        score += evil_points[item.0] * points;
        score
    });
    if good_score > evil_score {
        good_wins
    }else if evil_score > good_score {
        evil_wins
    }else{
        tie
    }
  }

fn main(){
    assert_eq!(good_vs_evil("0 0 0 0 0 10", "0 0 0 0 0 0 0"), "Battle Result: Good triumphs over Evil");
    assert_eq!(good_vs_evil("0 0 0 0 0 0", "0 0 0 0 0 0 10"), "Battle Result: Evil eradicates all trace of Good");
    assert_eq!(good_vs_evil("0 0 0 0 0 10", "0 0 0 0 0 0 10"), "Battle Result: No victor on this battle field");    
}