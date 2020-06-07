package com.huang.solution;

import com.huang.definition.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
*/

// 之前做最多的是由前序和中序遍历构建二叉树，这个题是从后序和中序构建二叉树。
// 注意后序遍历要从最后开始遍历
public class BuildTreeFromInorderAndPostorder_106 {
    HashMap<Integer, Integer> hm = new HashMap ();
    int postorderIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++){
            hm.put(inorder[i], i);
        }
        return build(postorder, 0, hm.size()-1);
    }

    public TreeNode build(int [] postorder, int inL, int inR){
        if(inL > inR){
            return null;
        }
        TreeNode node = new TreeNode(postorder[postorderIndex--]);
        int inIndex = hm.get(node.val);
        node.right = build(postorder, inIndex + 1, inR);
        node.left = build(postorder, inL, inIndex - 1);
        return node;
    }

    public static void main(String[] args) {
        int [] inorder = new int []{9,3,15,20,7};
        int [] postorder = new int [] {9,15,7,20,3};
        TreeNode ret = new BuildTreeFromInorderAndPostorder_106().buildTree(inorder, postorder);
        String out = treeNodeToString(ret);
        System.out.println(out);

    }

    public static String treeNodeToString(TreeNode root){
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
