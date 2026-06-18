import java.util.Random;

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int len = mat.length - 1;
        int col = mat[0].length - 1;
        for (int i = 0; i <= len; i++) {
            int left = 0;
            int right = col;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int value = mat[i][mid];
                if (mid <= col && value < mat[i][mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            System.out.println("while");
            int value = mat[i][left];
            boolean status = true;

            boolean notLastColumn = left < col;
            boolean notFirstCOlumn = left > 0;

            boolean notLastRow = i < len;
            boolean notFirstRow = i > 0;
            // if (notFirstRow) {
            // if (notFirstCOlumn && value < mat[i - 1][left - 1])
            // status = false;
            // if (notLastColumn && value < mat[i - 1][left + 1])
            // status = false;
            // }
            // if (notLastRow) {
            // if (notFirstCOlumn && value < mat[i + 1][left - 1])
            // status = false;
            // if (notLastColumn && value < mat[i + 1][left + 1])
            // status = false;
            // }
            if(status && notFirstCOlumn && value < mat[i][left - 1])status = false;
            if (status && notFirstRow && (value < mat[i - 1][left]))
                status = false;
            if (status && notLastRow && (value < mat[i + 1][left]))
                status = false;
            if (status) {
                return new int[] { i, left };
            }
        }
        return new int[] { -1, -1 };
    }
}

public class lc_search_in_2D_array_II {

    static boolean isPeak(int[][] mat, int[] ans) {
        int i = ans[0];
        int j = ans[1];

        int value = mat[i][j];

        if (i > 0 && mat[i - 1][j] >= value)
            return false;

        if (i < mat.length - 1 && mat[i + 1][j] >= value)
            return false;

        if (j > 0 && mat[i][j - 1] >= value)
            return false;

        if (j < mat[0].length - 1 && mat[i][j + 1] >= value)
            return false;

        return true;
    }

    static int[][] generateMatrix(int rows, int cols) {

        Random random = new Random();

        int[][] mat = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int value;

                while (true) {
                    value = random.nextInt(10000);

                    boolean ok = true;

                    if (i > 0 && mat[i - 1][j] == value)
                        ok = false;

                    if (j > 0 && mat[i][j - 1] == value)
                        ok = false;

                    if (ok)
                        break;
                }

                mat[i][j] = value;
            }
        }

        return mat;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[][][] tests = {

                generateMatrix(3, 3),

                generateMatrix(10, 20),

                generateMatrix(50, 50),

                generateMatrix(100, 100),

                generateMatrix(100, 200),
                {
                        { 47, 30, 35, 8, 25 },
                        { 6, 36, 19, 41, 40 },
                        { 24, 37, 13, 46, 5 },
                        { 3, 43, 15, 50, 19 },
                        { 6, 15, 7, 25, 18 }
                }

        };

        for (int i = 0; i < tests.length; i++) {

            int[] ans = sol.findPeakGrid(tests[i]);

            if (isPeak(tests[i], ans)) {

                System.out.println(
                        "Test " + (i + 1) +
                                " PASS -> [" + ans[0] + "," + ans[1] + "]");

            } else {

                System.out.println(
                        "Test " + (i + 1) +
                                " FAIL");
            }
        }
    }
}