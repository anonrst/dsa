class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) /2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}


public class search_in_rotated_sorted_array {
    public static void main(String[] args) {
        int[] testcase = {4, 5, 6,7,8,9,0,1};
        int result = new Solution().search(testcase, 8);
        System.out.println(result== 4);
    }
}