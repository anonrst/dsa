class Solution {
    public double floorSqrt(int n) {
        int left = 1;
        int right =n;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if((long)mid*mid <= n){
                ans = mid;
                left += 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}

public class FIND_SQRT_OF_A_NUMBER {

public static void main(String[] args) {
    double n = new Solution().floorSqrt(15);
    System.out.println(n);
}
}