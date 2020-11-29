//https://www.codewars.com/kata/55983863da40caa2c900004e/train/rust

fn next_bigger_number(n: i64) -> i64 {
    let mut nums : Vec<u8>  = n.to_string().as_bytes().iter().map(|v| v - 48).collect::<Vec<u8>>();
    let original = nums.iter().map(|v| v.to_string()).collect::<String>().parse::<i64>().unwrap();
    let mut tmp_num : i64 = nums.iter().map(|v| v.to_string()).collect::<String>().parse::<i64>().unwrap();
    let mut tmp_swap : u8;
    //println!("to string --> {:?}",nums);
    //println!("aaaaa -> {:?}",n.to_string().as_str().chars().collect::<Vec<char>>());
    for i in (1..nums.len()).rev() {
        //println!("nums[i] : {}  nums[i - 1] : {}",nums[i],nums[i-1]);
        //if nums[i] > nums[i - 1] {
            tmp_swap = nums[i - 1];
            nums[i - 1] = nums[i];
            nums[i] = tmp_swap;
            tmp_num = nums.iter().map(|v| v.to_string()).collect::<String>().parse::<i64>().unwrap();
        //}
        if tmp_num > original {
            //println!("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            break;
        }
        //println!("i -> {}",nums[i]);
    }
    //println!("nums --> {:?}",nums);
    //println!("nums join -> {:?}",nums.iter().map(|v| v.to_string()).collect::<String>().parse::<i64>().unwrap());
    tmp_num
}


fn main(){
    println!("Hello from next bigger number");
    assert_eq!(21, next_bigger_number(12));
    assert_eq!(531, next_bigger_number(513));
    assert_eq!(2071, next_bigger_number(2017));
    assert_eq!(441, next_bigger_number(414));
    assert_eq!(414, next_bigger_number(144));
    assert_eq!(1234567908, next_bigger_number(1234567890));
    assert_eq!(7366765815417392456, next_bigger_number(7366765815417369542));

    println!("{}",next_bigger_number(1234567890)); // 1234567908
    println!("{}",next_bigger_number(7366765815417369542)); // 7366765815417392456
}