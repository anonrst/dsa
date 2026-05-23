class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        boolean isEven = false;
        if((m + n ) % 2 == 0) isEven = true;
        int[] medianIndex = {(m+n)/2};
        if(isEven){
            medianIndex[1] =  ((m+n)/2) + 1;
        }
        if(nums1[m - 1] < nums2[0]){
            if(!isEven){
                int OddMedianIndex = medianIndex[0];
                if(OddMedianIndex >= m){
                    return nums2[OddMedianIndex - m];
                }else{
                    return  (nums2[OddMedianIndex - m] + nums2[OddMedianIndex - m + 2]) /2;
                }
            }
        }
    }
}

public class find_the_median_of_two_sorted_array {

    public static void main(String[] args) {
        int[] m1 = {1, 2};
        int[] m2 = {3};

        double resul = new Solution().findMedianSortedArrays(m1, m2);
        System.out.println(resul == 2.00);
    }
}