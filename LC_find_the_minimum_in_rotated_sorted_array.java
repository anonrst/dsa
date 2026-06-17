class Solution {
    public static int findMin(int[] nums) {
        int high = nums.length - 1;
        int low= 0;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return nums[low];       
    }
}
public class LC_find_the_minimum_in_rotated_sorted_array {

public static void main(String[] args) {
    int[] test1 = {4,5,6,7,0,1,2};
    int[] test2 = {7,0,1,2,4,5,6};
    int[] test3 = {0,1,2,4,5,6,7};
    int[] test4 = {2,1};
    int[] test5 = {10,0,1,2,3,4,5,6,7,8,9};

    System.out.println(Solution.findMin(test1) == 0);
    System.out.println(Solution.findMin(test2) == 0);
    System.out.println(Solution.findMin(test3) == 0);
    System.out.println(Solution.findMin(test4) == 1);
    System.out.println(Solution.findMin(test5) == 0);
}
}