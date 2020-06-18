package com.huang.solution;

import java.util.ArrayList;
import java.util.List;

/*78. 子集
* 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

//传入下标是i+1
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, list, new ArrayList<>(),0);
        return list;
    }
    private void helper(int[] nums, List<List<Integer>> list, List<Integer> curList, int startIndex){
        list.add(new ArrayList<>(curList));

        for(int i = startIndex; i < nums.length; i++){
            curList.add(nums[i]);
            helper(nums, list, curList, i+1);
            curList.remove(curList.size()-1);
        }
    }
    public static void main(String[] args) {

        int[] nums = new int [] {1,2,3};

        List<List<Integer>> ret = new Subsets_78().subsets(nums);

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
