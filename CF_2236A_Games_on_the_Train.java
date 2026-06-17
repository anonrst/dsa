import java.util.Scanner;

public class CF_2236A_Games_on_the_Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases-- > 0){
            int numberOfTowers = sc.nextInt();
            int[] heightsOfTower = new int[numberOfTowers];
            int smallest = Integer.MAX_VALUE;
            int biggest = Integer.MIN_VALUE;
            for(int i = 0; i < numberOfTowers; i++){
                int vale = sc.nextInt();
                heightsOfTower[i] = vale;
                if(vale < smallest)smallest = vale;
                if(vale > biggest) biggest =vale;
            }
            int value = (biggest - smallest) + 1;
            System.out.println(value);
        }
    }
}
