class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int flowerReuired = m * k;
        int n = bloomDay.length;
        if (n < flowerReuired)
            return -1;
        int maxDays = Integer.MIN_VALUE;
        int mininumDays = Integer.MAX_VALUE;
        for (int x : bloomDay) {
            maxDays = Math.max(maxDays, x);
            mininumDays = Math.min(mininumDays, x);
        }
        int ans = -1;
        while (mininumDays <= maxDays) {
            int mid = mininumDays + (maxDays - mininumDays) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                maxDays = mid - 1;
            } else {
                mininumDays = mid + 1;
            }
        }
        return ans;
    }

    boolean canMake(int[] bloomdays, int m, int k, int days) {
        int flowers = 0;
        int boquests = 0;
        for (int x : bloomdays) {
            if (x <= days) {
                flowers++;
                if (flowers == k) {
                    boquests++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return boquests >= m;
    }
}

public class minimum_dasy_to_make_m_boquets {
    public static void main(String[] args) {
        int[] testcase = { 7, 7, 7, 7, 12, 7, 7 };
        int resul = new Solution().minDays(testcase, 2, 3);
        System.out.println(resul == 12);
    }
}
