package com.huang.solution;

import com.huang.definition.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*124. 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42
*/

// max 记录 左节点 + 右节点 + 自己 的值 的最大
//重点是return时，返回给上一层的节点应该是return left > right ? left + 本身.val : right + 本身.val
// 如果是负数的话就返回0，意味不要这个点了
public class MaxPathSum_124 {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){
        helper(root);

        return max;
    }

    private int helper(TreeNode node){
        if(node == null) return 0;

        int left = helper(node.left);

        int right = helper(node.right);

        max = Math.max(max, left + right + node.val);

        return Math.max(0, Math.max(left, right) + node.val); //【0】 必要がある！ 如果是负数的话就不要了
    }

    public static void main(String[] args) {
        String input = "[-10,9,20,null,null,15,7]";

        TreeNode root = stringToTreeNode(input);

        int ret = new MaxPathSum_124().maxPathSum(root);

        String out = String.valueOf(ret);

        System.out.println(out);
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
