#include <vector>
#include <iostream>
#include <unordered_map>
#include <cmath>
using namespace std;
class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        vector<int> result = {};
        for(int x: nums){
            int m = x;
            int l = 0;
            while(x > 0){
                l++;
                x /= 10;
            }
            for(int i =l-1; i > 0; i--){
                int last = m / (int)pow(10, i);
                result.push_back(last);
                m %=(int) pow(10,i);
            }
            result.push_back(m);
        }
        return result;
    }
};

int main(){
    vector<int> testcase = {33,234,5678,90,22,23};
    vector<int> expected = {3,3,2,3,4,5,6,7,8,9,0,2,2,2,3};
    Solution* s = new Solution();
    vector<int> r = s->separateDigits(testcase);
    cout << (r == expected) << '\n';
    return 0;
}