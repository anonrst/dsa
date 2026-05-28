import java.util.Scanner;
public class CF_2217A_THE_EQUALIZER_800R {
  public static void main(String[] atgs) {
    Scanner s = new Scanner(System.in);
    int tests = s.nextInt();
    while (tests-- > 0) {
      int[] LenAndK = new int[2];
      LenAndK[0] = s.nextInt();
      LenAndK[1] = s.nextInt();
      int k = LenAndK[1];
      int[] nums = new int[LenAndK[0]];
      int sum = 0;
      for (int i = 0; i < LenAndK[0]; i++) {
        nums[i] = s.nextInt();
        sum += nums[i];
      }
      if (sum % 2 == 0) {
        int newSum = (LenAndK[0])*k; //now all the element xecelt at index zero can be rrplaced by k, becausr of consttaint     ai(1≤i≤n)
        boolean isEvenK = newSum % 2 == 0;
        if (isEvenK) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      } else {
        System.out.println("YES");
      }
    }
        s.close();
  }
}
