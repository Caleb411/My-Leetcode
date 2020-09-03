/// Source : https://leetcode-cn.com/problems/sort-colors/
/// Author : chenlin
/// Time   : 2020-09-03
/// Updated: 2020-09-03

// 3 ways quick sort
// Time Complexity: O(nlogn)
// Space Complexity: O(1)
class Solution {
    public void sortColors(int[] nums) {
        if(nums.length == 0) return;
        Random rnd = new Random();
        sort(nums, 0, nums.length-1, rnd);
    }

    private void sort(int[] arr, int l, int r, Random rnd){
        // 首先处理递归到底的情况
        if(l>=r) return;

        // 随机在[l...r]中选取标定点
        int p = l + rnd.nextInt(r-l+1);
        swap(arr, l, p);

        // [l+1...lt] < v, [lt+1...i-1] == v, [gt...r] > v
        int lt = l;
        int i = l+1;
        int gt = r+1;

        // partition
        while(i < gt){
            if(arr[i] < arr[l]){
                lt++;
                swap(arr, i, lt);
                i++;
            }else if(arr[i] > arr[l]){
                gt--;
                swap(arr, i, gt);
            }else{
                i++;
            }
        }
        swap(arr, l, lt);
        // [l...lt-1] < v, [lt...gt-1] == v, [gt...r] > v
        sort(arr, l, lt-1, rnd);
        sort(arr, gt, r, rnd);
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        new Solution().sortColors(nums);
    }
}
