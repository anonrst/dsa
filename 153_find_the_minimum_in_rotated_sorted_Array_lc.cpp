#include <iostream>
#include <vector>
using namespace std;

    
class Solution {
public:
    static int findMin(vector<int>& nums) {
        int high = nums.size() - 1;
        int low= 0;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else if(nums[mid] < nums[right]){
                high  = mid;
            }else{
                high--;
            }
        }
        return nums[low];         
    }
};

int main(){
    vector<int> testcase = {3,4,5,6,7,8,9,11,12,13,14,15,16,17,89,1,2};
    int expected = 1;
    int result = Solution::findMin(testcase);
    cout << (expected == result ) << '\n';
}

