

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int orderBreakCount = 0;
        for(int i = 0; i < n - 1; i++){
            if(nums[i] > nums[(i + 1)%n]){
                orderBreakCount++;
            }
            if(orderBreakCount > 1)return false;
        }
        return true;
    }
}


public class check_if_array_is_sorted_or_rotated {

public static void main(String[] args) {
    int[] testcase = { 4, 5,6, 1,22,2, 3};
    boolean s= new Solution().check(testcase);
    System.out.println(s == false);
}    
}