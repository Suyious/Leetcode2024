fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let size = nums.len();
    let mut answer: Vec<i32> = vec![];
    let mut results: Vec<(i32, usize)> = vec![];
    for i in 0..size {
        results.push((nums[i], i));
    }

    results.sort_by(|a, b| a.0.cmp(&b.0));

    let mut i = 0;
    let mut j = size - 1;
    while i < j {
        let sum = results[i].0 + results[j].0;
        if sum > target {
            j -= 1;
        } else if sum < target {
            i += 1;
        } else {
            answer.push(results[i].1 as i32);
            answer.push(results[j].1 as i32);
            break;
        }
    }
    return answer;
    
}

fn main() {
    println!("{:?}", two_sum(vec![3,7,2,15], 9));
}