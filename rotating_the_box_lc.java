import java.util.Arrays;
class Solution {
    public char[][] rotating_the_box(char[][] boxGrid){
        char[][] result = new char[boxGrid[0].length][boxGrid.length];
        int m = boxGrid.length,  n = boxGrid[0].length;
        for(int j = 0; j < m; j++){
            for(int k = n - 1 ; k >= 0; k--){
                char currChar = boxGrid[j][k];
                if(currChar == '#' && k < n){
                    int mark = k;
                    while(mark < n - 1 && boxGrid[j][mark + 1] == '.' ){
                        mark++;
                    }
                    boxGrid[j][k] = '.';
                    boxGrid[j][mark] = currChar;
                }
            }
        }
        for(int j = 0; j < m; j++){
            for(int k = 0; k < n; k++){
                result[k][m - 1 - j] = boxGrid[j][k];
            }
        }
        return result;
    };
}

public class ROTATING_THE_BOX_LC {
    public static void main(String[] args){
        Solution s  = new Solution();
        char[][] testcases = {{'#','.','#'}};
        char[][] expected = {{'.'}, {'#'}, {'#'}};
        char[][] result = s.rotating_the_box(testcases);
        System.out.println(Arrays.deepEquals(result, expected));
    }
}