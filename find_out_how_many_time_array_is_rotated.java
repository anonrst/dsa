class Solution {
    int findKRotations(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = arr[mid];
            if (arr[left] <= val && val > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

public class find_out_how_many_time_array_is_rotated {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] tests = {
            {4, 5, 1, 2, 3},       // expected 2
            {3, 4, 5, 6, 1, 2},    // expected 4
            {1, 2, 3, 4, 5},       // expected 0
            {5, 1, 2, 3, 4}        // expected 1
        };

        int[] expected = {2, 4, 0, 1};

        for (int i = 0; i < tests.length; i++) {
            int ans = sol.findKRotations(tests[i]);

            if (ans == expected[i]) {
                System.out.println("Test " + (i + 1) + ": PASS");
            } else {
                System.out.println(
                    "Test " + (i + 1) +
                    ": FAIL (Expected " + expected[i] +
                    ", Got " + ans + ")"
                );
            }
        }
    }
}