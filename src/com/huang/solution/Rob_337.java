package com.huang.solution;

import com.huang.definition.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*337. 打家劫舍 III
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

输出: 7
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
*/

// 超级厉害！！！！
// arr[0] 表示不抢root的话，得到的最大钱数
// arr[1] 表示抢root的话，得到的最大钱数
public class Rob_337 {
    public int rob(TreeNode root) {
        int[] dp = dp(root);
        return Math.max(dp[0], dp[1]);
    }

    // arr[0] 表示不抢root的话，得到的最大钱数
    // arr[1] 表示抢root的话，得到的最大钱数
    private int[] dp(TreeNode node){
        if(node == null) return new int []{0, 0};

        int[] left = dp(node.left);
        int[] right = dp(node.right);

        // 抢了root，那么left和right都不能抢了
        int rob = node.val + left[0] + right[0];
        // 不抢root，那么left和right 可 以 抢，但是抢还是不抢取决于值不值得抢
        int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int []{not_rob, rob};
    }

    public static void main(String[] args) {
        String input = "3,4,5,1,3,null,1";

        TreeNode root = stringToTreeNode(input);

        int rob = new Rob_337().rob(root);

        System.out.println(rob);
    }

    public static TreeNode stringToTreeNode(String input) {
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
