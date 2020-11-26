/// Source : https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
/// Author : chenlin
/// Time   : 2020-11-26
/// Updated: 2020-11-26

// divide-and-conquer
// Time Complexity: O(n!)
// Space Complexity: O(n^2)
class Solution {

    HashMap<String, List<Integer>> memo = new HashMap<>();
    // 递归函数定义：计算算式 input 所有可能的运算结果
    public List<Integer> diffWaysToCompute(String input) {
        if(memo.containsKey(input)) return memo.get(input);
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < input.length();i++){
            char cur = input.charAt(i);
            // 以每个运算符作为分割点
            if(cur == '+' || cur == '-' || cur == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(int l: left){
                    for(int r: right){
                        if(cur == '+'){
                            res.add(l+r);
                        }
                        if(cur == '-'){
                            res.add(l-r);
                        }
                        if(cur == '*'){
                            res.add(l*r);
                        }
                    }
                }
            }
        }
        // base case
        if(res.isEmpty()){
            res.add(Integer.parseInt(input));
        }
        memo.put(input, res);
        return res;
    }
}
