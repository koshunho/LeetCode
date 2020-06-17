package com.huang.solution;
/*34. 在排序数组中查找元素的第一个和最后一个位置
* 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
*/

// 二分查找的综合运用，即使是背都要背下来
public class SearchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        int l = leftBound(nums, target);

        int r = rightBound(nums, target);

        return new int []{l, r};
    }

    private int leftBound(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){    //停止
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){  //收紧右侧，以锁定左侧
                right = mid;
            }
            else if(nums[mid] < target){   //当nums[mid]被检测后，下一步的搜索区间应该去掉mid分割成两个区间[left, mid) 和 [mid+1, right)
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid;
            }
        }
        if(left == nums.length) return -1;
        return nums[left] == target ? left : -1; //不一定找到哦，只能说明nums中小于target的元素有多少个。必须判断是不是就是target
    }

    private int rightBound(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                left = mid + 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid;
            }
        }
        if(right == 0) return -1;
        return nums[right-1] == target ? right-1 : -1;  //因为left = mid+1，所以无论返回left还是rihgt，都要减去1
    }

    public static void main(String[] args) {
        int [] nums = new int [] {5,7,7,8,8,10};

        int target = 8;

        int[] arr = new SearchRange_34().searchRange(nums, target);

        String out = integerArrayToString(arr);

        System.out.println(out);
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
