
macro_rules! solutionClass {
    () => {
        Solution {}
    };
}

struct Solution {}



impl Solution {
    fn subArraywith0sum(&self,nums: Vec<i32>) -> i32 {
        let mut total = 0;
        let mut longestSubArray = 0;
        for &x in &nums {
            total += x;
        }
        let vlen = nums.len();
        for x in 0..vlen {
            let mut currentTotalSum = total;
            if x != 0 {                            
                currentTotalSum = total - nums[x - 1];
            }
            let mut right = vlen - 1;
            let mut leftSubarray = 0;
            while x < right {                       
                if currentTotalSum - leftSubarray == 0 {
                    longestSubArray = std::cmp::max(longestSubArray, (right - x + 1) as i32);
                    break;
                } else {
                    leftSubarray += nums[right];
                }
                right -= 1;
            }
        }
        return longestSubArray;
    }
}

fn main() {                                         
    let testcase: Vec<i32> = vec![12, -23, 23, 0, 34, 43, -77, 5, 6, 1, -4, -2]; 
    let expected: i32 = 6;
    let s: Solution = solutionClass!();
    let result : i32 = s.subArraywith0sum(testcase); 
    println!("{}", expected == result);
}