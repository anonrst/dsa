class Solution {
    public static int kthElement(int[] a, int[] b, int k) {
        int left = 0;
        int right = 0;
        int index = 0;
        while (index <= k) {
            if (a[left] <= b[right] && left < a.length) {
                index++;
                if (index == k) {
                    return a[left];
                }
                left++;
            } else {
                index++;
                if (index == k) {
                    return b[right];
                }
                right++;
            }

        }
        return 0;
    }
}

public class A2Z_KTH_ELEMENT_OF_TWP_SORTED_ARRAY {

    public static void main(String[] args) {
      
        int[] test1 = { 100, 112, 256, 349, 770};
        int[] test2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;
        int expected = 256;
        int result = Solution.kthElement(test1, test2, k);
        System.out.println(expected == result);
    }
}