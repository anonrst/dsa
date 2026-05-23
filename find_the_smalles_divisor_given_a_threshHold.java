class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 1;
        int right = 0;
        for(int x:nums){
            right = Math.max(right, x);
        }
        int ans = left;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if(canMakeSum(nums, threshold, mid)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    boolean canMakeSum(int[] nums, int threshold, int divisor){
        System.out.println(divisor);
        double sum = 0;
        for(int x: nums){
            sum += (x + divisor - 1) /divisor;
        }
        System.out.println(sum <= threshold);
        return sum <= threshold;
    }
}

public class find_the_smalles_divisor_given_a_threshHold {

    public static void main(String[] args) {
        int[] testcase = {1,2,5,9};
        int resul = new Solution().smallestDivisor(testcase, 6);
        System.out.println(resul == 5);
    }
}