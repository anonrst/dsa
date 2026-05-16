import java.util.Vector;
import java.util.*;
class Solution{
    public static Vector<Integer> bubble_sort(Vector<Integer> nums){  
        long start = System.nanoTime(); 
        for(int i = 0; i < nums.size() - 1; i++){
            for(int j = 0; j < nums.size() - i - 1;j++){
                if(nums.get(j) > nums.get(j + 1)){
                    Swap(nums, j , j + 1);
                }
            }
        }
        long end= System.nanoTime();
        System.out.println((end - start) / 1_000_000.0 + " ms");
        return nums;
    }

    public static void Swap(Vector<Integer> nums, int i , int j){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}

public class bubble_sort {
    public static void main(String[] args) {
        
        Vector<Integer> testcase = new Vector<Integer>(Arrays.asList(7,8,9,0,6,5,3,2,1,4));
        Vector<Integer> expected = new Vector<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        Vector<Integer> result = Solution.bubble_sort(testcase);
        System.out.println(expected.equals(result));
        
    }
}
