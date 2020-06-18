package com.huang.solution;

import com.huang.definition.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*我们从二叉树的根节点 root 开始进行深度优先搜索。

在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。

如果节点只有一个子节点，那么保证该子节点为左子节点。

给出遍历输出 S，还原树并返回其根节点 root。

 
示例 1：

输入："1-2--3--4-5--6--7"
输出：[1,2,5,3,4,6,7]

示例 2：

输入："1-2--3---4-5--6---7"
输出：[1,2,5,3,null,6,null,4,null,7]

示例 3：

输入："1-401--349---90--88"
输出：[1,401,null,349,88,90]
 

提示：

原始树中的节点数介于 1 和 1000 之间。
每个节点的值介于 1 和 10 ^ 9 之间。
*/

//2020.6.18 每日一题
public class RecoverFromPreorder_1028 {
    public TreeNode recoverFromPreorder(String S) {
        if(S.length() == 0) return null;
        int degree = 0, cur = 0;
        HashMap <Integer, TreeNode> hm = new HashMap<>();
        String num = "";
        while(cur < S.length() && S.charAt(cur) != '-'){
            num += S.charAt(cur);
            cur++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(num));
        hm.put(degree, root);

        for(int i = cur; i < S.length();){

            while (S.charAt(i) == '-'){
                degree++;
                i++;
            }
            String str = "";
            while(i < S.length() && Character.isDigit(S.charAt(i))){
                str += S.charAt(i);
                i++;
            }

            TreeNode node = new TreeNode(Integer.parseInt(str));
            TreeNode parent = hm.get(degree-1);

            if(parent.left == null){
                parent.left = node;
            }
            else{
                parent.right = node;
            }

            hm.put(degree, node);
            degree = 0;
        }
        return root;
    }

    public static void main(String[] args) {
        String s = "1-2--3---4-5--6---7";

        TreeNode ret = new RecoverFromPreorder_1028().recoverFromPreorder(s);

        String out = treeNodeToString(ret);

        System.out.print(out);
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

            output += node.val + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
}
