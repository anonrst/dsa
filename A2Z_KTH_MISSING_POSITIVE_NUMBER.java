class Solution {
  public int findKthPositive(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int lost = arr[mid] - 1 - mid;
      if (lost < k) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low + k;
  }
}

public class A2Z_KTH_MISSING_POSITIVE_NUMBER {
  public static void main(String[] args) {
    int[] tetscase = {3, 4, 5, 9, 10};
    double expected = 8;
    double result = new Solution().findKthPositive(tetscase, 5);
    System.out.println(result == expected);
  }
}
