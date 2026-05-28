class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int leastWeight = 0;
        int maxWeight = 0;
        for(int x: weights){
            leastWeight = Math.max(leastWeight, x);
            maxWeight += x;
        }
        int ans = 0;
        while(leastWeight <= maxWeight){
            int weightCapac = leastWeight + (maxWeight - leastWeight) /2;
            if(canCompleteThisCapacity(weights,days, weightCapac)){
                maxWeight = weightCapac - 1;
                ans = weightCapac;
            }else{
                leastWeight = weightCapac + 1;
            }
        }
        return ans;
    }

    boolean canCompleteThisCapacity(int[] packages, int days,int capacity){
        int daysDone = 1;
        int OneDayCapcacity = 0;

        for(int x: packages){
            if((OneDayCapcacity + x) > capacity){
                daysDone++;
                OneDayCapcacity = x;
            }else{
                OneDayCapcacity += x;
            }
            if(daysDone > days) return false;
        }
        return true;
    }

}
public class CAPACITY_TO_SHIP_PACKAGES_WITHIN_D_DAYS {
public static void main(String[] args) {
 int[] testcase = {3,2,2,4,1,4};
 int result = new Solution().shipWithinDays(testcase, 3);
 System.out.println(result == 6);   
}
    
}