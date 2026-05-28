 class Solution {
    public int paint(int A, int B, int[] C){
        int[] boards = C;
        int painters = A;
        int rightTimeU = 0;
        int LeftTime = 0;
        for(int x:boards){
            rightTimeU += x;
            LeftTime = Math.max(x, LeftTime);
        }
        rightTimeU = rightTimeU*B;
        LeftTime = LeftTime*B;
        int ans = LeftTime;
        while(LeftTime <= rightTimeU){
            int mid = LeftTime + (rightTimeU -  LeftTime)/2;
            if(canPaintInTIme(boards, painters, mid, B)){
                rightTimeU = mid - 1;
                ans  = mid;
            }else{
                LeftTime = mid + 1;
            }
        }
        return ans;
    }
    boolean canPaintInTIme(int[] boards, int painters, int time, int onetine){
        int paintersDone = 0;
        int timeUsed  = 0;
        for(int x: boards){
            if((timeUsed + (x*onetine)) > time){
                timeUsed = x;
                paintersDone++;
            }else{
                timeUsed += x;
            }
            if(paintersDone > painters) return false;
        }

        return true;
    }
    
}
public class PAINTERS_PATITION_PROBLEM {
public static void main(String[] args) {
    int[] testcase = {1, 8, 11, 3};
    int timeAPaintersTakesTwoPaintAUnitArea  =1;
    int numberofPainters = 10;
    int resul = new Solution().paint(numberofPainters,timeAPaintersTakesTwoPaintAUnitArea,testcase);
    System.out.println(resul == 11);
}
    
}