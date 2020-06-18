package com.huang.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*47. 全排列 II
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

// 超级好的分析
// https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
public class PermuteUnique_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;

        List<List<Integer>> list = new ArrayList<>();

        boolean [] used = new boolean[len];

        Arrays.sort(nums);

        helper(nums, list, new ArrayList<>(), used);

        return list;
    }

    private void helper(int[] nums, List<List<Integer>> list, List<Integer> curList, boolean [] used){
        if(curList.size() == nums.length){
            list.add(new ArrayList<>(curList));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            if(i >= 1 && nums[i] == nums[i-1] && used[i-1]) continue; //搜索的数也和上一次一样，但是上一次的 1 刚刚被撤销，正是因为刚被撤销，下面的搜索中还会使用到，因此会产生重复，剪掉的就应该是这样的分支

            curList.add(nums[i]);

            used[i] = true;

            helper(nums, list, curList, used);

            used[i] = false;
            curList.remove(curList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int [] {1,1,2};

        List<List<Integer>> ret = new PermuteUnique_47().permuteUnique(nums);

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

