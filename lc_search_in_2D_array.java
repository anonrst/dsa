class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int rowlen = matrix[0].length;
        int left= 0;
        int right = rows*rowlen - 1; 
        while(left <= right){
          int mid = left + (right -left)/2;
          int row = mid / rowlen;
          int index = mid % rowlen;
          int value = matrix[row][index];
          if(value == target)return true;
          if(value > target){
            right = mid - 1;
          }else{
            left = mid + 1;
          }
        }
        return false;
    }
}


public class lc_search_in_2D_array {
    public static void main(String[] args) {
        Solution s = new Solution();

        // Test Case 1
        int[][] m1 = {
            {1}
        };
        System.out.println(s.searchMatrix(m1, 1)); // Expected: true

        // Test Case 2
        int[][] m2 = {
            {1}
        };
        System.out.println(s.searchMatrix(m2, 2)); // Expected: false

        // Test Case 3
        int[][] m3 = {
            {1, 3, 5},
            {7, 9, 11},
            {13, 15, 17}
        };
        System.out.println(s.searchMatrix(m3, 13)); // Expected: true

        // Test Case 4
        int[][] m4 = {
            {1, 3, 5},
            {7, 9, 11},
            {13, 15, 17}
        };
        System.out.println(s.searchMatrix(m4, 2)); // Expected: false

        // Test Case 5
        int[][] m5 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(s.searchMatrix(m5, 9)); // Expected: true
    }
}