class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int rowlen = matrix[0].length;
        int left= 0;
        int right = rowlen - 1; 
        int top = 0;
        int down = rows - 1;
        while(left <= right && top <= down){
          int index = left + (right -left)/2;
          int row = top + ( down - top)/2;
          int value = matrix[row][index];
          if(value == target)return true;
          if(value > target){
            down = row - 1;
          }else{u
            top = row + 1;
          }
          if(value > target){
            right = index - 1;
          }else{
            left = index + 1;
          }
        }
        return false;
    }
}

public class lc_search_in_2D_array_II {
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