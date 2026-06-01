class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int totalLength =  (a + b);
        int left = 0;
        int right = 0;
        int prev = 0;
        int curr = 0;
        for(int i = 0; i <= totalLength/2; i++){
            prev = curr;

            if(left < a && (nums1[left] < nums2[right] || right >= b)){
                curr = nums1[left++];
            }else{
                curr  = nums2[right++];
            }
        }

        if(totalLength % 2 == 1){
            return curr;
        }
        return (prev + curr)  /2.00;

    }
}

public class A2Z_MEDIAN_OF_TWO_SORTED_ARRAY {
    public static void main(String[] args) {
        int[] testcase = {1,3,5};
        int[] testcase2 = {2,4};
        double answer  = new Solution().findMedianSortedArrays(testcase, testcase2);
        System.out.println(answer == 3.000);
    }

}