package com.huang.solution;
/*738. 单调递增的数字
给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。）

示例 1:

输入: N = 10
输出: 9
示例 2:

输入: N = 1234
输出: 1234
示例 3:

输入: N = 332
输出: 299
说明: N是在[0, 10^9]范围内的一个整数*/
public class MonotoneIncreasingDigits_738 {
    public int monotoneIncreasingDigits(int N) {
        if(N < 10) return N;
        char[] arr = String.valueOf(N).toCharArray();
        for (int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] > arr[i + 1]){
                arr[i]--;
                for(int j = i + 1; j < arr.length; j++){
                    arr[j] = '9';
                }
            }
        }
        return Integer.parseInt(String.valueOf(arr));
    }

    public static void main(String[] args) {
        int N = 332222222;
        int i = new MonotoneIncreasingDigits_738().monotoneIncreasingDigits(N);
        System.out.println(i);
    }
}
