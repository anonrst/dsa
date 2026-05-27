import java.util.*;

class Solution {
  public int numberOfSpecialChars(String word) {
    char[] letters = word.toCharArray();
    int[] lastLower = new int[26];
    Arrays.fill(lastLower, -1);
    int[] firstUpper = new int[26];
    Arrays.fill(firstUpper, -1);
    int n = letters.length;
    for (int i = 0; i < n; i++) {
      char lett = letters[i];
      if (Character.isLowerCase(lett)) {
        lastLower[lett - 'a'] = i;
      } else {
        int inx = lett - 'A';
        if (firstUpper[inx] == -1) {
          firstUpper[inx] = i;
        }
      }
    }
    int result = 0;
    for (int i = 0; i < 26; i++) {
      if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
        result++;
      }
    }
    return result;
  }
}

public class LC_COUNT_THE_NUMBER_OF_SPECIAL_CHARACTER_2 {
  public static void main(String[] args) {
    Solution s = new Solution();

    String word = "aaAbcBC";
    int result = s.numberOfSpecialChars(word);

    System.out.println(result);
  }
}
