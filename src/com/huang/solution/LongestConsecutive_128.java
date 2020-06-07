package com.huang.solution;
/*128. 最长连续序列
给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。*/

// 核心思路：一旦一个数被扫描，直接将其从Set中踢出！
// 有点像顺藤摸瓜的感觉，找到一条线的一点，就直接把整根拔起。
import java.util.HashSet;

public class LongestConsecutive_128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet();
        for(int i = 0; i < nums.length; i++){
            hs.add(nums[i]);
        }
        int maxLen = 1;
        for(int num: nums){
            if(hs.remove(num)){
                int cur = num;
                int curLen = 1;
                while(hs.remove(cur-1)) cur--;
                curLen += num - cur;
                cur = num;
                while(hs.remove(cur+1)) cur++;
                curLen += cur - num;
                maxLen = Math.max(curLen, maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int [] nums = new int []{100, 4, 200, 1, 3, 2};

        LongestConsecutive_128 longestConsecutive_128 = new LongestConsecutive_128();
        int result = longestConsecutive_128.longestConsecutive(nums);
        System.out.println(result);
    }
}
