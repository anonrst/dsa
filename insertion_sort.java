import java.util.*;

class Solution {
    public static Vector<Integer> insertion_sort(Vector<Integer> nums){
        for(int j = 1; j < nums.size();j++){
            int curr = nums.get(j);
            int k = j - 1;
            while (k >= 0 && nums.get(k) > curr) {
                nums.set(k + 1, nums.get(k));
                k--;
            }
            nums.set(k + 1, curr);
        }
        return nums;
    }

    public static void swap(Vector<Integer> nums, int a, int b){
        int temp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, temp);
    }
}

public class INSERTION_SORT {

    public static void main(String[] args) {
        Vector<Integer> testcase = new Vector<Integer>(Arrays.asList(7,8,9,4,6,5,3,2,1,0));
        Vector<Integer> expected = new Vector<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        Vector<Integer> result = Solution.insertion_sort(testcase);
        System.out.println(expected.equals(result));
    }
}