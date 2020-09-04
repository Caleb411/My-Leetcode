/// Source : https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
/// Author : chenlin
/// Time   : 2020-09-04
/// Updated: 2020-09-04

// sort2ways
// Time Complexity: O(n)
// Space Complexity: O(logn)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Random rnd = new Random();
        sort(arr, 0, arr.length-1, rnd, k-1);
        int[] res = new int[k];
        for(int i = 0;i<res.length;i++){
            res[i] = arr[i];
        }
        return res;
    }

    private void sort(int[] arr, int l, int r, Random rnd, int k){
        if(l>=r) return;
        int p = partition(arr, l, r, rnd);
        if(p == k){
            return;
        }else if(p > k){
            sort(arr, l, p-1, rnd, k);
        }else{
            sort(arr, p+1, r, rnd, k);
        }
    }

    private int partition(int[] arr, int l, int r, Random rnd){
        int p = l + rnd.nextInt(r-l+1);
        swap(arr, l, p);

        int i = l + 1;
        int j = r;
        while(true){
            while(i<=j&&arr[i]<arr[l]){
                i++;
            }
            while(j>=i&&arr[j]>arr[l]){
                j--;
            }

            if(i >= j) break;

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
