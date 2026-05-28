class Solution {
    public int NthRoot(int N, int M) {
        int left = 0;
        int right = M;
        while (left <= right) {
            int mid = left + (right  - left ) /2;
            int val = 1;
            for(int i = 0; i < N; i++){
                val *= mid;
                if(val > M) break;
            }

            if(val == M) return mid;
            if(val < M){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}


public class FIND_NTH_ROOT_OF_A_NUMBER {
    
    public static void main(String[] args) {
        int result = new Solution().NthRoot(4, 16);
        System.out.println(result == 2);
    }
}
