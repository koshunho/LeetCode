package com.huang.solution;

import java.util.Arrays;

/*978. 最长湍流子数组
* 当 A的子数组A[i], A[i+1], ..., A[j]满足下列条件时，我们称其为湍流子数组：

若i <= k < j，当 k为奇数时，A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
或 若i <= k < j，当 k 为偶数时，A[k] > A[k+1]，且当 k为奇数时，A[k] < A[k+1]。
也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

返回 A 的最大湍流子数组的长度。



示例 1：
输入：[9,4,2,10,7,8,8,1,9]
输出：5
解释：(A[1] > A[2] < A[3] > A[4] < A[5])
示例 2：

输入：[4,8,12,16]
输出：2
示例 3：

输入：[100]
输出：1


提示：

1 <= A.length <= 40000
0 <= A[i] <= 10^9
*/

// https://leetcode-cn.com/problems/longest-turbulent-subarray/solution/yi-zhang-dong-tu-xiang-jie-dong-tai-gui-wrwvn/
// 这个题解的图画的特别好，不过有一点arr[i] == arr[i-1]的时候，应该没必要判断
public class MaxTurbulenceSize_978 {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return 1;
        }
        int [] up = new int [len];
        int [] down = new int [len];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) {
                up[i] = down[i - 1] + 1;
            } else if (arr[i] < arr[i - 1]) {
               down[i] = up[i - 1] + 1;
            }
            ans = Math.max(ans, Math.max(up[i], down[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = new int [] {9,4,2,10,7,8,8,1,9};
        int i = new MaxTurbulenceSize_978().maxTurbulenceSize(arr);
        System.out.println(i);
    }
}
