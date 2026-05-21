import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int x:nums){
            xor ^= x;
        }
        return xor;
    }
}

public class find_the_single_number_in_array_of_pairss {

    public static void main(String[] args) {
        int[] testcase = {1, 2, 2, 4, 3, 1, 4};
        int main =new Solution().singleNumber(testcase);
        System.out.println(main == 3);
    }
}