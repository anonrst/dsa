class Solution {
     public int maxSubarraySumCircular(int[] nums) {
        int localsum = nums[0];
        int globalsum = nums[0];
        int localmin = nums[0];
        int globalmin = nums[0];
        int total = nums[0];
        for(int i = 1; i < nums.length; i++){
            localmin = Math.min(localmin + nums[i], nums[i]); 
            globalmin = Math.min(localmin,globalmin); 
            localsum = Math.max( nums[i], nums[i] + localsum);
            globalsum = Math.max(localsum,globalsum); 
            total += nums[i];
        }
        return globalsum > 0 ? Math.max(globalsum, total - globalmin): globalsum;
    }

}
public class MAXIMUM_SUM_CIRCULAR_SUBARRAY_LC {

    public static void main(String[] args) {
        int[] test = {1,-2,3,-2};
        Solution s = new Solution();
        int a = s.maxSubarraySumCircular(test);
        System.out.println(a == 3);
    }
}