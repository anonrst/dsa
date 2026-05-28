import java.util.Arrays;

class Solution {
    int maxPossibleDistance(int[] stallsPositions, int AggCows){
        int minPossibleD = 1;
        int minE = Integer.MAX_VALUE;
        int maxE = Integer.MIN_VALUE;
        for(int x: stallsPositions){
            minE = Math.min(minE, x);
            maxE = Math.max(maxE, x);
        }
        int maxPossibleD = maxE - minE;
        int ans = 0;
        Arrays.sort(stallsPositions);
        while(minPossibleD <= maxPossibleD){
            int midPossibleD =  minPossibleD + (maxPossibleD - minPossibleD)/2;
            if(isPossibleWithThisGap(stallsPositions, AggCows, midPossibleD)){
                minPossibleD = midPossibleD + 1;
                ans  = midPossibleD;
            }else{
                maxPossibleD = midPossibleD - 1;
            }
        }
        return ans;
    }

    boolean isPossibleWithThisGap(int[] stalls, int cows, int distance){
        int cowPlaced = 1;
        // {0,3,4,7,10,9}
        int startDistance = 0;
        for(int x: stalls){
            if((x - startDistance )>= distance){
                cowPlaced++;
                startDistance = x;
            }
        }
        System.out.printf("%s => %s\n",distance,cowPlaced >= cows);
        if(cowPlaced < cows) return false;
        return true;
    }
}

public class AGGRESSIVE_COWS {

    public static void main(String[] args) {
        int[] testcase = {4,2,1,3,6};
        int aggCows = 2;
        int rsult = new Solution().maxPossibleDistance(testcase, aggCows);
        System.out.println(rsult == 5);
    }
}