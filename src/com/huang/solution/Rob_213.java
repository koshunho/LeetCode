package com.huang.solution;

import java.util.Arrays;

/*213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [2,3,2]
输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2:

输入: [1,2,3,1]
输出: 4
解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。*/

// 这道题很有意思，在198的基础上拓展了。
// 首先，首尾房间不能同时被抢，那么只可能有3种情况：
// 1. 首尾都不被抢
// 2. 第一间被抢，最后一间不抢
// 3. 第一间不抢，最后一间被抢
// 所以就是比较这三种结果那个最大就是最终答案
// 但是其实只要比较2和3就可以，因为2和3的选择余地比1大，房子的钱数都是非负数，所以选择余地大，最优决策不会小
// 特别注意！！Arrays.copyOfRange是左闭右开的！
public class Rob_213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        //copyOfRange(int []original,int from,int to),original为原始的int型数组，from为开始角标值，to为终止角标值。（其中包括from角标，不包括to角标。即处于[from,to)状态）
        // 左闭右开！！！！！
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length-1)), helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int helper(int[] nums){
        int len = nums.length;

        if(len == 0) return 0;

        if(len == 1) return nums[0];

        int [] dp = new int [len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[len-1];
    }

    public static void main(String[] args) {
        int[] nums = new int []{1,2,3,1};

        int rob = new Rob_213().rob(nums);

        System.out.println(rob);
    }
}
