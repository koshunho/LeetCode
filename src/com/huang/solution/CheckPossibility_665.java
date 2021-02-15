package com.huang.solution;
/*665. 非递减数列
* 给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的：对于数组中所有的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。



示例 1:

输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
示例 2:

输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。


说明：

1 <= n <= 10 ^ 4
- 10 ^ 5 <= nums[i] <= 10 ^ 5
*/

// https://leetcode-cn.com/problems/non-decreasing-array/solution/3-zhang-dong-tu-bang-zhu-ni-li-jie-zhe-d-06gi/
// 思路见上
// 简而言之，就是每三个元素 下标为1 2 3. 是让第2个元素变小（变得跟第3个元素一样小），还是让第3个元素变大（变得跟第2个元素一样大）。
// 这就取决于第1个元素比第3个元素大还是小
public class CheckPossibility_665 {
    public boolean checkPossibility(int[] nums) {
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]) {
                flag++;
                if(flag > 1) {
                    return false;
                }
                if(i == 1 || nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }
}
