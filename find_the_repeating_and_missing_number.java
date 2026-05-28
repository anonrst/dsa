
 class Solution {
    static public int[] findMissingAndRepeatingNumber(int[] nums){
        long n = nums.length;
        long resultSumAB = 0;
        long resultSQSumAB = 0;
        for(int x: nums){
            resultSumAB += (long)x;
            resultSQSumAB += (long)x*x;
        }
        long expectedSumAB = n * (n + 1)/ 2;
        long expectedSQSumAB = (n * (n + 1) * (2 * n + 1)) / 6;

        long ABminus = resultSumAB - expectedSumAB;
        long ABPlus = (resultSQSumAB - expectedSQSumAB) / ABminus;
        long A = (ABPlus + ABminus )/ 2;
        long B = A - ABminus;
        System.err.println((int)A);
        return new int[]{(int)A, (int)B};
    }
}
public class FIND_THE_REPEATING_AND_MISSING_NUMBER {
    public static void main(String[] args) {
        int[] testcase = {1,2,3,4,6,6};
        int[] expected  ={6,5};
        int[] result = Solution.findMissingAndRepeatingNumber(testcase);
        System.out.println(result == expected);
    }
}
