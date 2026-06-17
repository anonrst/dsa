class Solution {
    public int rowWithMax1s(int[][] mat) {
        int maxOne = mat[0].length;
        int value = 0;
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            int left = 0;
            int right = maxOne - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (mat[i][mid] == 0) {
                    left = mid + 1;
                }
                {
                    right = mid - 1;
                }
            }
            int count = maxOne - left;
            if (value == count)
                continue;
            if (value < count)
                res = i;
        }
        return res;
    }
}

public class find_maximum_ones_in_mat {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][][] tests = {
                {
                        { 0, 0, 1, 1 },
                        { 0, 1, 1, 1 },
                        { 0, 0, 0, 1 }
                }, // expected: 1

                {
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 0, 0, 0 }
                }, // expected: 0

                {
                        { 1, 1, 1 },
                        { 0, 1, 1 },
                        { 0, 0, 1 }
                }, // expected: 0

                {
                        { 0, 0, 1, 1, 1 },
                        { 0, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 1, 1 }
                }, // expected: 2

                {
                        { 0, 1 },
                        { 1, 1 },
                        { 0, 0 },
                        { 0, 1 }
                } // expected: 1
        };

        int[] expected = { 1, 0, 0, 2, 1 };

        for (int i = 0; i < tests.length; i++) {
            int ans = sol.rowWithMax1s(tests[i]);

            if (ans == expected[i]) {
                System.out.println("Test " + (i + 1) + ": PASS");
            } else {
                System.out.println(
                        "Test " + (i + 1) +
                                ": FAIL (Expected " + expected[i] +
                                ", Got " + ans + ")");
            }
        }
    }
}
