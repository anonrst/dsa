class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid + 1]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }else{
                if(nums[mid] == nums[mid - 1]){
                    left = mid+ 1;
                }else{
                    right = mid;
                }
            }
        }
        return nums[left];
    }
}
public class LC_find_the_minimum_in_sorted_array {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testCases = {
            {1, 1, 2, 3, 3, 4, 4, 8, 8},     // Expected: 2
            {3, 3, 7, 7, 10, 11, 11},        // Expected: 10
            {0, 1, 1, 2, 2, 3, 3},           // Expected: 0
            {1, 1, 2, 2, 3, 4, 4},           // Expected: 3
            {5}                              // Expected: 5
        };

        int[] expected = {2, 10, 0, 3, 5};

        for (int i = 0; i < testCases.length; i++) {
            int result = sol.singleNonDuplicate(testCases[i]);

            System.out.println(
                "Test " + (i + 1) +
                " -> Expected: " + expected[i] +
                ", Got: " + result +
                " : " + (result == expected[i] ? "PASS" : "FAIL")
            );
        }
    }
}