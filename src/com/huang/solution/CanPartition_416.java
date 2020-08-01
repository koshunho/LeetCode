package com.huang.solution;
/*416. 分割等和子集
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].
 

示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.
*/

// DP真的好嗨难啊
public class CanPartition_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0) return false;

        sum = sum / 2;

        // dp[i][j]指的是 0,..,i这个区间中，是否存在这个区间和为j。 sum + 1(包括0, 0 —> sum)
        boolean [][] dp = new boolean[nums.length][sum+1];

        // base: dp[i][0] = true。因为区间和为0，我所有数的都不放进背包不就行了，不就能让背包的区间和为0了嘛
        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j <= sum; j++){
                // 如果前i-1的区间已经存在和为j了，那么我现在就直接为true了
                dp[i][j] = dp[i-1][j];

                // 如果要把nums[i]放进背包，我就看看前i-1的区间里面有没有区间和为j - nums[i]
                if(nums[i] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][sum];
    }

    public static void main(String[] args) {
        int [] nums = new int [] {3,3,4,3,5};

        boolean b = new CanPartition_416().canPartition(nums);

        System.out.println(b);
    }
}
