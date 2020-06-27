package com.huang.solution;
/*41. 缺失的第一个正数
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

 

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1
 

提示：

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
*/

//这题怎么那么像剑指offer的题
// 要找的数一定在 [1, N + 1]。（N是数组长度）
//  1 这个数放到下标为 0 的位置， 2 这个数放到下标为 1 的位置，按照这种思路整理一遍数组。
//  然后我们再遍历一次数组，第 1 个遇到的它的值不等于下标的那个数，就是我们要找的缺失的第一个正数。
// from @liweiwei1419 weiwei大佬
public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while(nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i]-1]){
                // 不能乱序！ 必须先取temp = nums[nums[i-1]]
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if(nums[i] != i + 1){
                return i + 1;
            }
        }

        return len + 1;
    }

    public static void main(String[] args) {
        int [] nums = {3,4,-1,1};

        int ret = new FirstMissingPositive_41().firstMissingPositive(nums);

        System.out.println(ret);
    }
}
