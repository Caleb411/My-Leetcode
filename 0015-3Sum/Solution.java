/// Source : https://leetcode-cn.com/problems/3sum/
/// Author : chenlin
/// Time   : 2020-10-08
/// Updated: 2020-10-08

// sort + two pointers
// Time Complexity: O(nlogn)+O(n^2)=O(n^2)
// Space Complexity: O(1)
// 为了避免重复按从小到大的顺序找出所有满足条件的三个数（前提是先将数组排序）
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }

    private List<List<Integer>> threeSum(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        // 穷举threeSum的第一个数
        for(int i = 0;i < n;i++){
            // 对target-nums[i]计算twoSum
            int rest = target - nums[i];
            List<List<Integer>> temp = twoSum(nums, i+1, rest);
            for(List<Integer> list: temp){
                list.add(nums[i]);
                res.add(list);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while(i < n-1 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }

    // 从start开始的两数之和（找出所有并且避免重复）
    private List<List<Integer>> twoSum(int[] nums, int start, int target){
        int left = start;
        int right = nums.length-1;
        List<List<Integer>> res = new ArrayList<>();
        while(left < right){
            int sum = nums[left]+nums[right];
            int l = nums[left];
            int r = nums[right];
            if(target == sum){
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                res.add(list);
                while(left<right && nums[left] == l) left++;
                while(left<right && nums[right] == r) right--;
            }else if(target < sum){
                while(left<right && nums[right] == r) right--;
            }else{
                while(left<right && nums[left] == l) left++;
            }
        }
        return res;
    }
}
