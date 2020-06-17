package com.huang.solution;
/*42. 接雨水
*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6*/

// 找出当前下标的左右两边 第一次出现的 比自己高的 柱子。
// 该下标能装的水就取决于 上述中 较短的那一根的柱子长度 - 自己本身的高度
public class Trap_42 {
    public int trap(int[] height) {
        int len = height.length;

        int[] leftMax = new int [len];
        int[] rightMax = new int [len];

        leftMax[0] = height[0];
        rightMax[len-1] = height[len-1];

        for(int i = 1; i < len; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for(int i = len-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int ans = 0;
        for(int i = 1; i < len-1; i++){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int []{0,1,0,2,1,0,1,3,2,1,2,1};

        int trap = new Trap_42().trap(height);

        System.out.println(trap);
    }
}
