package com.huang.solution;
/*315. 计算右侧小于当前元素的个数
* 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

 

示例：

输入：[5,2,6,1]
输出：[2,1,1,0]
解释：
5 的右侧有 2 个更小的元素 (2 和 1)
2 的右侧仅有 1 个更小的元素 (1)
6 的右侧有 1 个更小的元素 (1)
1 的右侧有 0 个更小的元素
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BST
// 好像第一次做把普通数组转化成二叉搜索树的题？
public class CountSmaller_315 {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;

        if(len == 0) return new ArrayList<>();

        Integer [] res = new Integer [len];

        Arrays.fill(res, 0);

        TreeNode root = new TreeNode(nums[len-1]);

        // 反向遍历，因为是求右边的嘛
        for (int i = len - 2; i >= 0; i--) {
            build(root, new TreeNode(nums[i]), res, i);
        }

        return Arrays.asList(res);
    }

    private TreeNode build(TreeNode root, TreeNode node, Integer[] res, int index){
        if(root == null){
            return node;
        }

        // 当前node的值小于root，放左子树
        if(root.val >= node.val){
            root.count++;
            root.left = build(root.left, node, res, index);
        }else{
            // 别忘了 + 1，root也是比当前node小的
            res[index] += root.count + 1;
            root.right = build(root.right, node, res, index);
        }

        return root;
    }

    private class TreeNode{
        int val;

        //记录左子树的个数
        int count;

        TreeNode left;

        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int [] nums = new int [] {5,2,6,1};

        List<Integer> ret = new CountSmaller_315().countSmaller(nums);

        String s = integerArrayListToString(ret);

        System.out.println(s);
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += number + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
}


