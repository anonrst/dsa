#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    static void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        --m;
        int left = m - n;
        int right = n - 1;
        while(left >= 0 && right >= 0){
            if(nums1[left] < nums2[right]){
                nums1[m--] = nums2[right--];
                cout << nums1[left] << " < " << nums2[right + 1] << " = " << nums1[m + 1] <<'\n';
            }else{
                int temp=  nums1[left];
                nums1[left--] == 0;
                nums1[m--] = temp;
                cout << nums1[left + 1] << " > " << nums2[right] << " = " << nums1[m + 1] <<'\n';
            }
        }
    }
};

int main(){
    vector<int> testcase1 = {-5, -2, 4, 5, 0, 0, 0};
    vector<int> testcase2 = {-3, 1, 8};
    vector<int> expected = {-5, -3, -2, 1, 4, 5, 8};
    Solution::merge(testcase1, testcase1.size(), testcase2, testcase2.size());
    cout << (testcase1 == expected) << '\n';
}