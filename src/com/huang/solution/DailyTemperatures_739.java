package com.huang.solution;
/*739. 每日温度
请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

。*/

import java.util.Stack;

// 单调栈 (while)如果比栈顶元素大，就让栈顶元素出栈，直到掏空栈 or 掏不动栈了.
// 将当前元素下标入栈
public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        Stack<Integer> stack = new Stack<>();
        int [] ans = new int [len];
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int cur = stack.pop();
                ans[cur] = i-cur;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] temperatures = new int []{73, 74, 75, 71, 69, 72, 76, 73};
        int [] ret = new DailyTemperatures_739().dailyTemperatures(temperatures);
        String out = integerArrayToString(ret);
        System.out.println(out);
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += number + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
}
