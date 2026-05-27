import java.util.Scanner;
public class CF_1919A_WALLET_EXCHANGE_800R {
  public static void main(String[] args){
    Scanner s = new java.util.Scanner(System.in);
    int tests = s.nextInt();
    while(tests-- > 0){
      int A = s.nextInt();
      int B = s.nextInt();
      int  result = A - B;
      if(result % 2 == 0){
        System.out.println("Bob");
      }else{
        System.out.println("Alice");
      }
    }
  }
}