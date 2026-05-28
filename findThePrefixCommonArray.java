import java.util.Arrays;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n + 1];
        int[] ans = new int[n];
        int common = 0;
        for (int i = 0; i < n; i++) {
            freq[A[i]]++;
            if (freq[A[i]] % 2 >= 0) {
                int count = freq[A[i]];
                common += count / 2;
            };
            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                int count = freq[B[i]];
                common += count / 2;
            }
            ans[i] = common;
        }

        return ans;
    }
}

public class FINDTHEPREFIXCOMMONARRAY {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] testcaseA = { 1, 3, 2, 4, 2 };
        int[] testcaseB = { 3, 1, 2, 4, 2 };
        int[] exptected = { 0, 2, 3, 4, 5 };
        int[] result = s.findThePrefixCommonArray(testcaseA, testcaseB);
        System.out.println(result[4]);
        System.out.println(Arrays.equals(exptected, result));
    }
}