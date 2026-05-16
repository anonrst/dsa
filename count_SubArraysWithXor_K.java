import java.util.HashMap;
import java.utils.ArrayList;

static class Solution {
    static public int count_SubArraysWithXor_K(ArrayList<Integer> nums, int k){
        int xor = 0;
        HashMap<Integer,Integer> prefixXor = new HashMap<>();
        int count = 0;
        for(Integer x: nums){
            xor ^= x;
            int rplaceK = xor^k;
            prefixXor.put(xor, prefixXor.getOrDefault(xor, 0) + 1);
        }
    }
}

public class count_SubArraysWithXor_K {
    public static void main(){
        ArrayList<Integer> testcase = {4, 2, 2, 6, 4};
        int expected =6;
        int result = Solution.count_SubArraysWithXor_K(testcase, 6);
        System.out.println(result);
    }
}