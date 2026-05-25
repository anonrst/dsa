#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        int n = s.length();

        vector<int> visited(n, 0);
        visited[0] = 1;

        queue<int> q;
        q.push(0);

        int farCovered = 0;

        while (!q.empty()) {
            int node = q.front();
            q.pop();

            if (node == n - 1)
                return true;

            int start = max(farCovered + 1, minJump + node);
            int end = min(node + maxJump, n - 1);

            for (int i = start; i <= end; i++) {
                if (s[i] == '0' && !visited[i]) {
                    visited[i] = 1;
                    q.push(i);
                }
            }

            farCovered = end;
        }

        return false;
    }
};

int main() {
    string s = "01101110";
    int maxJump = 3;
    int minJump = 2;

    bool result = Solution().canReach(s, minJump, maxJump);

    cout << (result == false) << '\n';

    return 0;
}