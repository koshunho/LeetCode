package com.huang.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

// 传入下标去重。也就是因为【较深层的结点值考虑了之前考虑过的元素】
// 比如说candidates = [2,3,6,7], target = 7 画出递归树
// 2(剩余5) 2（剩余3） 3（剩余0）
// 以3开始 3（剩余4） 2（剩余2） 2（剩余0） 这个就完全没必要再重头考虑 因为先排序candidates。说得有些笼统不好理解 画出递归树比较好懂
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        helper(candidates, target, list, 0, new ArrayList<Integer>());
        return list;
    }

    private void helper(int[] candidates, int difference, List<List<Integer>> list, int startIndex, List<Integer> curList){
        if(difference == 0){
            list.add(new ArrayList<>(curList));
        }

        if(difference < 0) return;

        for(int i = startIndex; i < candidates.length; i++){
            curList.add(candidates[i]);
            helper(candidates, difference - candidates[i], list, i, curList);
            curList.remove(curList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int [] {2,3,6,7};

        int target = 7;

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
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
}

