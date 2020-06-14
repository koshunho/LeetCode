package com.huang.solution;

import java.util.Arrays;
/* 1300. 转变数组后最接近目标值的数组和
* 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。

如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。

请注意，答案不一定是 arr 中的数字。

 

示例 1：

输入：arr = [4,9,3], target = 10
输出：3
解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
示例 2：

输入：arr = [2,3,5], target = 10
输出：5
示例 3：

输入：arr = [60864,25176,27249,21296,20204], target = 56803
输出：11361
 

提示：

1 <= arr.length <= 10^4
1 <= arr[i], target <= 10^5
。*/
//假设存在一个x，能使数组中大于这个x的元素都变成x。
//那么我想通过这个值，使得我整个数组变更之后的和 最接近于 target。
//原数组中小于x的所有值之和 + x 乘 (原数组中大于x的个数) = target
public class FindBestValue_1300 {
    public int findBestValue(int[] arr, int target) {
        int curSum = 0;
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            int quotient = target - curSum;
            if(quotient / (arr.length - i) < arr[i]){
                double d = (double) quotient / (arr.length - i);
                ans = (int)Math.round(d - 0.1); //因为floor方法是+0.5后向下取整，这题[4,9,3] targer=10测试用例会报错。因为 7 / 2 =3.5 要取3而不是4
                return ans;
            }
            curSum += arr[i];
        }
        return arr[arr.length-1];
    }

    public static void main(String[] args) {
        int [] arr = new int []{4,9,3};

        int target = 10;

        int ret = new FindBestValue_1300().findBestValue(arr, target);

        String out = String.valueOf(ret);

        System.out.println(out);
    }
}
