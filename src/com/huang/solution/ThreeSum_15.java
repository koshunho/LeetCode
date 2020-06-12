package com.huang.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
。*/

// 经典题。如果等于同时收缩，>0则left++， <0则right--
// 注意去重的操作
public class ThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(len < 3) return ans;
        Arrays.sort(nums);

        for(int i = 0; i < len-2; i++){
            if(nums[i] > 0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1, right=len-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left+1] == nums[left]) left++;
                    while(left < right && nums[right-1] == nums[right]) right--;
                    left++;
                    right--;
                }
                else if(sum > 0) right--;
                else if(sum < 0) left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = new int []{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = new ThreeSum_15().threeSum(nums);

        String out = int2dListToString(lists);

        System.out.println(out);
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

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
