import java.util.HashSet;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxPrefixLen = 0;
        int m = arr1.length;
        int n = arr2.length;

        HashSet<Integer> allAprefix = new HashSet<>();
        for(int i = 0; i < m; i++){
            int c = arr1[i];
            while(c > 0){
                allAprefix.add(c);
                c /= 10;
            }
        }
        for(int i = 0; i < n; i++){
            int c = arr2[i];
            double minAllowed = Math.pow(10, (double)maxPrefixLen);
            while(c >= minAllowed){
                if(allAprefix.contains(c)){
                    maxPrefixLen = Math.max(maxPrefixLen, countPrefixLen(c));
                    break;
                }
                    c /= 10;
            }
        }

        return maxPrefixLen;

    }
        int countPrefixLen(int num1){
            int count = 0;
        while(num1 > 0){
                num1 /= 10;
                count++;
            }
        return count;
        }
}

public class find_the_length_of_comman_prefix_pair {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] testcase1 = {1,10,100};
        int[] testcase2 = {1000};
        int largestPrefixlen = s.longestCommonPrefix(testcase1, testcase2);
        System.out.println(largestPrefixlen == 3);  
    }
}
