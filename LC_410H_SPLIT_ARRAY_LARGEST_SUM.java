import java.util.*;

class Solution {
  public int splitArray(int[] nums, int k) {
    int minSum = 0;
    int maxSum = 0;
    for (int x : nums) {
      minSum = Math.max(minSum, x);
      maxSum += x;
    }
    int ans = maxSum;
    while (minSum < maxSum) {
      int midSum = minSum + (maxSum - minSum) / 2;
      System.out.println(midSum);
      if (isKsubArrPossWithSum(nums, k, midSum)) {
        maxSum = midSum - 1;
        ans = midSum;
      } else {
        minSum = midSum + 1;
      }
    }
    return ans;
  }

  public boolean isKsubArrPossWithSum(int[] nums, int k, int midSum) {
    int currSum = 0;
    int count = 1;
    
    for (int x : nums) {
      currSum += x;
      if (currSum > midSum) {
        count++;
        currSum = x;
      }
      System.out.println(" => " + currSum + " <= ");
    }
      System.out.println(count);
      return count <= k;
  }
}

public class LC_410H_SPLIT_ARRAY_LARGEST_SUM {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] word = {7, 2, 5, 10, 8};
    int result = s.splitArray(word, 2);
    System.out.println(result == 18);
  }
}
