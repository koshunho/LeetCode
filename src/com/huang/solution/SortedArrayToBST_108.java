package com.huang.solution;

import com.huang.definition.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*108. 将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
*/
public class SortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        //左开右闭
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end){
        if(start >= end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid);
        node.right = helper(nums, mid+1, end);

        return node;
    }

    public static void main(String[] args) {
        int [] nums = new int []{-10,-3,0,5,9};

        TreeNode ret = new SortedArrayToBST_108().sortedArrayToBST(nums);

        String out = treeNodeToString(ret);

        System.out.println(out);
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

}
