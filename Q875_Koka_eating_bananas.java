
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = Integer.MIN_VALUE;
        for (int x : piles) {
            maxSpeed = Math.max(maxSpeed, x);
        }
        int ans = maxSpeed;
        while (minSpeed <= maxSpeed) {
            int midSpeed = minSpeed + (maxSpeed - minSpeed) /2;
            if(canEatAllInThisSpeed(piles, h, midSpeed)){
                ans = midSpeed;
                maxSpeed = midSpeed - 1;
            }else{
                minSpeed = midSpeed + 1;
            }
        }
        return ans;
    }

    boolean canEatAllInThisSpeed(int[] piles, int h, int speed){
        int hourItTake = 0;

        for(int x: piles){
            hourItTake +=  (x + speed - 1) / speed;
        }
        return hourItTake <= h;
    }
}

public class Q875_Koka_eating_bananas {
    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int value = new Solution().minEatingSpeed(piles, 8);
        System.out.println(value == 4);
    }
}
