

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


public class CHECK_IF_ARRAY_IS_SORTED_OR_ROTATED {

public static void main(String[] args) {
    int[] testcase = { 4, 5,6, 1,22,2, 3};
    boolean s= new Solution().check(testcase);
    System.out.println(s == false);
}    
}