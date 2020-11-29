// https://www.codewars.com/kata/5ce399e0047a45001c853c2b

fn parts_sums(ls: &[u64]) -> Vec<u64> {
    ls.into_iter().rfold(vec![0],|mut accum,x| {
        accum.push(accum.last().unwrap() + x);
        accum
    }).into_iter().rev().collect()
}




fn main(){
    assert_eq!(parts_sums(&vec![]), vec![0]);
    assert_eq!(parts_sums(&vec![0, 1, 3, 6, 10]), vec![20, 20, 19, 16, 10, 0]);
    assert_eq!(parts_sums(&vec![1, 2, 3, 4, 5, 6]), vec![21, 20, 18, 15, 11, 6, 0]);
    assert_eq!(parts_sums(&vec![744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358]),
     vec![10037855, 9293730, 9292795, 9292388, 9291934, 9291504, 9291414, 9291270, 2581057, 2580168, 2579358, 0]);
}