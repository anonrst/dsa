import java.util.Scanner;

public class CF_2236B_Tatar_TV_Show {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ts = sc.nextInt();
        while (ts-- > 0) {
            int len = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            char[] chars = s.toCharArray();
            int[] countOfOnes = new int[k];
            for(int i = 0; i < len; i++){
                if(chars[i] == 'i'){
                    countOfOnes[i%k]++;
                }
            }

            for(int i = 0; i < k; i++){
                if(countOfOnes[i]%2 != 0){
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }
        sc.close();
    }
}
