import java.util.Scanner;

public class CF_Omsk_2236C_Programmers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();
            int times = 0;
            while (a != b) {
                if (a > b) {
                    int diff = a - b;
                    int divdd = (a / x) - b;
                    if (divdd > diff) {
                        a /= x;
                    } else {
                        b++;
                    }
                } else {
                    int diff = b - a;
                    int divdd = (b/ x) - a;
                    if (divdd > diff) {
                        b /= x;
                    } else {
                        a++; 
                    }
                }
                times++; 
            }
            System.out.println(times);
        }
        sc.close();
    }
}
