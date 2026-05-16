
class Solution {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }else{
                right--;
            }
        }
        return nums[left];
    }
}
public class d154_find_the_miimum_in_rotated_sort_array_LC {
    public static void main(){
        int[] testcase = {3,3,1,3};
        int expected = 1;
        int result = Solution.findMin(testcase);
        System.out.println(result == expected);
        
    }
}
