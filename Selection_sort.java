import java.util.Arrays;
import java.util.Vector;

class Solution {
    public static Vector<Integer> Selection_sort(Vector<Integer> nums){
        int index = 0;
        int right = nums.size() - 1;
        while(index < right){
            int smallest = index;
            for(int i = index + 1; i <= right; i++){
                if(nums.get(i)< nums.get(smallest)){
                    smallest = i;
                }
            }
            int temp = nums.get(index);
            nums.set(index, nums.get(smallest));
            nums.set(smallest, temp);
            System.out.println(nums);
            index++;
        }
        return nums;
    }
}

public class Selection_sort {
    public static void main(String[] args) {
        Vector<Integer> testcase = new Vector<Integer>(Arrays.asList(7,8,9,4,6,5,3,2,1,0));
        Vector<Integer> expected = new Vector<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        Vector<Integer> result = Solution.Selection_sort(testcase);
        System.out.println(expected.equals(result));
    }
}
