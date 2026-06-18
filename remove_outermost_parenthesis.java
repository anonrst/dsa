import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

class Solution {
    public String removeOuterParentheses(String s) {
        int[] pars = new int[]{0,0};
        char[] lets = s.toCharArray();
        StringBuilder res = new StringBuilder();
        int depth = 0;
        for(int i = 0; i < lets.length; i++){
            if(lets[i] == '('){
                if(depth > 0){
                    res.append(lets[i]);
                }
                depth++;
            }else{
                depth--;
                if(depth > 0){
                    res.append(lets[i]);
                }
            }
        }
        return res.toString();
    }
}
public class remove_outermost_parenthesis {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[][] testCases = {
            {"(()())(())", "()()()"},
            {"(()())(())(()(()))", "()()()()(())"},
            {"()()", ""},
            {"((()))", "(())"},
            {"(()(()))", "()(())"},
            {"()", ""},
            {"(())", "()"},
            {"(((())))", "((()))"},
            {"(()())", "()()"},
            {"((())())", "(())()"},
            {"(()(()()()))", "()(()()())"},
            {"()()()()()", ""},
            {"((())(()))", "(())(())"},
            {"(()())(())(()(()))((()))", "()()()()(())(())"}
        };

        int passed = 0;

        for (int i = 0; i < testCases.length; i++) {
            String input = testCases[i][0];
            String expected = testCases[i][1];

            String actual = sol.removeOuterParentheses(input);

            boolean isPassed = expected.equals(actual);

            if (isPassed) {
                passed++;
            }

            System.out.println("Test Case #" + (i + 1));
            System.out.println("Input    : " + input);
            System.out.println("Expected : \"" + expected + "\"");
            System.out.println("Actual   : \"" + actual + "\"");
            System.out.println("Result   : " + (isPassed ? "PASS" : "FAIL"));
            System.out.println("----------------------------------");
        }

        System.out.println("Passed: " + passed + "/" + testCases.length);
    }
}
