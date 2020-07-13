package com.huang.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/*350. 两个数组的交集 II
给定两个数组，编写一个函数来计算它们的交集。

 

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]
 

说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
我们可以不考虑输出结果的顺序。
进阶：

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
*/

// 这题学到了Arrays.copyOfRange(intersection,0,index)哈哈
// 之前都是用一个List装之后再放进数组
public class Intersect_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            intersect(nums2,nums1);
        }

        int [] intersection = new int [nums1.length];

        HashMap<Integer,Integer> hm = new HashMap<>();

        for (int i : nums1) {
            hm.put(i, hm.getOrDefault(i,0) + 1);
        }

        int index = 0;
        for (int i : nums2) {
            if(hm.containsKey(i)){
                int count = hm.get(i);

                if(count == 0) {
                    hm.remove(i);
                    continue;
                }

                hm.put(i,--count);

                intersection[index++] = i;
            }
        }

        return Arrays.copyOfRange(intersection,0,index);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while ((line = in.readLine()) != null) {

            int[] nums1 = stringToIntegerArray(line);

            line = in.readLine();

            int[] nums2 = stringToIntegerArray(line);

            int[] ret = new Intersect_350().intersect(nums1, nums2);

            String out = integerArrayToString(ret);

            System.out.println(out);
        }
    }
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();

        input = input.substring(1, input.length() - 1);

        if (input.length() == 0) {

            return new int[0];

        }

        String[] parts = input.split(",");

        int[] output = new int[parts.length];

        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();

            output[index] = Integer.parseInt(part);
        }

        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
}
