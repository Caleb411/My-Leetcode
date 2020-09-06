/// Source : https://leetcode-cn.com/problems/container-with-most-water/
/// Author : chenlin
/// Time   : 2020-09-06
/// Updated: 2020-09-06

// collision pointers
// Time Complexity: O(n)
// Space Complexity: O(1)
// 扔掉了(n-2)+(n-3)+(n-4)+...+1=(n-1)*(n-2)/2这么多组合，只计算了n-1这么多组合，一共是n*(n-1)/2种组合
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while(l<r){
            int area = Math.min(height[l],height[r])*(r-l);
            ans = Math.max(area, ans);
            if(height[l]<=height[r]){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
}
