class Solution {
  public boolean asteroidsDestroyed(int mass, int[] asteroids) {
    Arrays.sort(asteroids);
    int totalMassOfPalnets = 0;
    int start = 0;
    int backward = start - 1;
    for (int i = 0; i < asteroids.length; i++) {
      // totalMassOfPalnets += asteroids[i];
      if (asteroids[i] < mass) start = i;
    }

    while (start < asteroids.length) {
      // totalMassOfPalnets += asteroids[i];
      if (mass < asteroids[start] && left >= 0) {
        mass += asteroids[backward--];
      } else if (mass >= asteroids[start]) {
        mass += asteroids[start++];

      } else {
        return false;
      }
    }
    return true;
  }
}

public class LC_2126_DESTROYING_ASTEROIDS {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] word = {7, 2, 5, 10, 8};
    int result = s.splitArray(word, 2);
    System.out.println(result == 18);
  }
}


