import java.util.Scanner;

public class CF_2217B_FLIP_THE_BIT_1000R {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int tests = s.nextInt();
    while (tests-- > 0) {
      int[] lenAndIndicesCount = new int[2];
      lenAndIndicesCount[0] = s.nextInt();
      lenAndIndicesCount[1] = s.nextInt();
      int[] bimaryArr = new int[lenAndIndicesCount[0]];
      for (int j = 0; j < lenAndIndicesCount[0]; j++) {
        bimaryArr[j] = s.nextInt();
      }
      int specialIndex = s.nextInt();
      int specialValue = bimaryArr[specialIndex - 1];
      int left = 0;
      int right = bimaryArr.length - 1;
      int count = 0;
      while (left < right) {
        count++;
        while (left <= specialIndex && bimaryArr[left] == specialValue) {
          left++;
        }
        while (specialIndex <= right && bimaryArr[right] == specialValue) {
          right--;
        }
        for (int i = left; i <= right; i++) {
          if (bimaryArr[i] == 0) {
            bimaryArr[i] = 1;
          } else {
            bimaryArr[i] = 0;
          }
        }
      }
      System.out.println(count);
    }
    s.close();

  }
}
