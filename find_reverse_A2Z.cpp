#include <iostream>
#include <vector>
using namespace std;

class Solution {
    public:
        static int CountReversePairs(vector<int>& nums){
            return separateArr(nums, 0, nums.size() - 1);
        } 
        static int mergeSort(vector<int>& nums, int low, int high, int med){
            int count = 0;
            int right = med + 1;
            for(int i = low; i <= med; i++){
                while(right <= high && nums[i] > 2*nums[right]){
                    right++;
                }
                count += right - (med + 1);
            }
            vector<int> temp;
            int l = low, r = med + 1;
            while(l <= med && r <= high){
                if(nums[l] <= nums[r]) temp.push_back(nums[l++]);
                else temp.push_back(nums[r++]);
            }
            while(l <= med)  temp.push_back(nums[l++]);
            while(r <= high) temp.push_back(nums[r++]);
            for(int i = low; i <= high; i++) nums[i] = temp[i - low];
            return count;
            }
        static int separateArr(vector<int>& nums, int low, int high){
            if(low >= high) return 0;
            int mid = low + (high - low) / 2;
            int count = 0;
            count += separateArr(nums, low, mid);
            count += separateArr(nums, mid + 1, high);
            count += mergeSort(nums, low, high, mid);
            return count;
        }
};

int main(){
vector<int> testcase = {6, 4, 1, 2, 7};
int expected = 3;
int result = Solution::CountReversePairs(testcase);
cout << (expected == result )<< '\n';
}