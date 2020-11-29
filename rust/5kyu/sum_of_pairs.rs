//https://www.codewars.com/kata/54d81488b981293527000c8f/train/rust


fn sum_pairs_old(ints: &[i8], s: i8) -> Option<(i8, i8)> {
    let mut a : usize = 0;
    let mut b : usize = 1;
    let mut c : usize = ints.len() - 1;
    let mut results : Vec<(usize,usize)> = vec![];
    while a < ints.len() && a < c{
        while b <= c{
            if ints[a] + ints[b] == s{
                results.push((a,b));
                c = b - 1;
                break;
            }
            b = b + 1;
        }
        a = a + 1;
        b = a + 1;
    }
    if results.is_empty(){
        None
    }else{
        results.sort_by(|a,b|{
            a.1.cmp(&b.1)
        });
        let result = results.first().unwrap();
        Some((ints[result.0],ints[result.1]))
    }
}

fn sum_pairs(ints: &[i8],s:i8) -> Option<(i8,i8)>{
    let mut nums = std::collections::HashMap::new();
    let mut results : Vec<(usize,usize)> = vec![];
    for i in 0..ints.len(){
        if let Some(n) = nums.get(&(s - ints[i])){
            results.push((*n,i));
        }
        nums.insert(ints[i],i);
    }
    if results.is_empty(){
        None
    }else{
        results.sort_by(|a,b|{
            a.1.cmp(&b.1)
        });
        let result = results.first().unwrap();
        Some((ints[result.0],ints[result.1]))
    }
}

fn main(){
    println!("Hello From sum of pairs");
    returns_expected();
}



fn returns_expected() {
    let l1 = [1, 4, 8, 7, 3, 15];
    let l2 = [1, -2, 3, 0, -6, 1];
    let l3 = [20, -13, 40];
    let l4 = [1, 2, 3, 4, 1, 0];
    let l5 = [10, 5, 2, 3, 7, 5];
    let l6 = [4, -2, 3, 3, 4];
    let l7 = [0, 2, 0];
    let l8 = [5, 9, 13, -3];
    assert_eq!(sum_pairs(&l1, 8), Some((1, 7)));
    assert_eq!(sum_pairs(&l2, -6), Some((0, -6)));
    assert_eq!(sum_pairs(&l3, -7), None);
    assert_eq!(sum_pairs(&l4, 2), Some((1, 1)));
    assert_eq!(sum_pairs(&l5, 10), Some((3, 7)));
    assert_eq!(sum_pairs(&l6, 8), Some((4, 4)));
    assert_eq!(sum_pairs(&l7, 0), Some((0, 0)));
    assert_eq!(sum_pairs(&l8, 10), Some((13, -3)));
}