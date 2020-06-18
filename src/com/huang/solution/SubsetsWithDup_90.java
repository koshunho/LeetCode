package com.huang.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*90. 子集 II
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/
public class SubsetsWithDup_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, list, new ArrayList<>(), 0);
        return list;
    }

    private void helper(int[] nums, List<List<Integer>> list, List<Integer> curList, int startIndex){
        list.add(new ArrayList<>(curList));

        for(int i = startIndex; i < nums.length; i++){
            if(i > startIndex && nums[i] == nums[i-1]) continue;
            curList.add(nums[i]);
            helper(nums, list, curList, i+1);
            curList.remove(curList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int [] {1,2,2};

        List<List<Integer>> ret = new SubsetsWithDup_90().subsetsWithDup(nums);

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
