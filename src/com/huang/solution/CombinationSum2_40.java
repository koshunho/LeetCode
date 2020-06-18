package com.huang.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
*/

// 39传入的是i，这题传入的是i+1
// 剪枝关键：if(i > startIndex && candidates[i] == candidates[i-1]) continue;
// 同层去重。i>start一定要理解，i是当前考察的元素下标，start是本层最开始的那个元素的下标，
// 答案能在Leetcode上跑出来 为什么在IDE上跑不出来。。。。

//我的理解 candidates = [10,1,2,7,6,1,5], target = 8 先排序 就是[1,1,2,5,6,7,10]
//既然当index = 0 的1 的 选项有 1 2 5 6 7 10 ，index = 1 的 1的选项也有 2 5 6 7 10 那么最先一个相同元素肯定包含了同一级的相同元素的答案

//无论是求组合/子集/排列，只要原数组中含有重复元素，通用一个去重方法：
// 1.先排序，使相同元素相邻；
// 2.在backtrack的for循环里：
//
//
// if(i>start&&candidates[i]==candidates[i-1]) continue;
//
// 作者：jin-ai-yi
// 链接：https://leetcode-cn.com/problems/combination-sum-ii/solution/he-xin-kao-dian-tong-ceng-qu-zhong-by-jin-ai-yi/
public class CombinationSum2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        helper(candidates, target, list, 0, 0, new ArrayList<Integer>());
        return list;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> list, int curSum, int startIndex, List<Integer> curList){
        if(curSum == target){
            list.add(new ArrayList<>(curList));
        }

        if(curSum > target) return;

        for(int i = startIndex; i < candidates.length; i++){

            if(i > startIndex && candidates[i] == candidates[i-1]) continue;

            curList.add(candidates[i]);
            helper(candidates, target, list, curSum + candidates[i], i+1, curList);
            curList.remove(curList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int [] {10,1,2,7,6,1,5};

        int target = 8;

        List<List<Integer>> ret = new CombinationSum_39().combinationSum(candidates, target);

        String out = int2dListToString(ret);

        System.out.println(out);

    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += number + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
}

