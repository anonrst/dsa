import java.util.*;
class Solution {
    public static int countMinSteps(int[] arr){
        int n = arr.length;
        if(n == 1) return 0;
        HashMap<Integer, ArrayList<Integer>> numsCount = new HashMap<>();
        for(int x =0; x< n; x++){
            numsCount.computeIfAbsent(arr[x], k -> new ArrayList<>()).add(x);
        }
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            step++;
            for(int ij = 0; ij < size; ij++){
                int index = queue.poll();
                if(index + 1 < n && !visited.contains(index + 1)){
                    if(index + 1 == n - 1) return step;
                    visited.add(index + 1);
                    queue.add(index + 1);
                }
                if(index - 1 >= 0 && !visited.contains(index)){
                    if(index - 1 == n -1) return step;
                    visited.add(index + 1);
                    queue.add(index + 1);
                }
                ArrayList<Integer> sameNums = numsCount.get(arr[index]);
                for(int i = 0; i < sameNums.size(); i++){
                    int numver = sameNums.get(i);
                    if(visited.contains(numver)) continue;
                    if(numver == n - 1) return step;
                    visited.add(numver);
                    queue.add(numver);
                }
            }

        };
        return -1;
    }
}


public class LC_JUMP_1V  {

    public static void main(String[] args) {
        int[] testcase = {1, 2, 3, 4,5,1, 2};
        int expected = 2;
        int result = Solution.countMinSteps(testcase);
        System.out.println(expected == result);
    }
}