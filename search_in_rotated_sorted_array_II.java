class Solution {
    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            while (low < high && nums[low] == nums[low + 1]) {
                low++;
            }
            while (low < high && nums[high] == nums[high - 1]) {
                high--;
            }
            if (nums[low] == nums[high] && low < high) {
                low++;
            }
            int mid = low + (high - low) / 2;
            int value = nums[mid];
            if (value == target) return true;

            // left most sorted
            if (nums[low] <= value) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right most sorted
                if (target > nums[high]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }
        return false;
    }
}

public class search_in_rotated_sorted_array_II {

    public static void main(String[] args) {
        int[] test = { 1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1};
        System.out.println(Solution.search(test, 0));
    }
}