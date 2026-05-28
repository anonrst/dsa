class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
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

public class FIND_THE_SMALLES_DIVISOR_GIVEN_A_THRESHHOLD {

    public static void main(String[] args) {
        int[] testcase = {1,2,5,9};
        int resul = new Solution().smallestDivisor(testcase, 6);
        System.out.println(resul == 5);
    }
}