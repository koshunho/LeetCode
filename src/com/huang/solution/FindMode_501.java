package com.huang.solution;

import com.huang.definition.TreeNode;

import java.util.*;

public class FindMode_501 {
    public int[] findMode(TreeNode root) {
        if(root == null) return new int [] {};

        Map<Integer, Integer> hm = new HashMap<>();

        helper(root, hm);

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(hm.entrySet());

        Collections.sort(entries, ((o1, o2) -> o2.getValue() - o1.getValue()));

        List<Integer> list = new ArrayList<>();

        int max = entries.get(0).getValue();

        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }

        int [] ans = new int [list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    private void helper(TreeNode node, Map<Integer, Integer> hm){
        if(node == null) return;

        hm.put(node.val, hm.getOrDefault(node.val, 0) + 1);

        helper(node.left, hm);
        helper(node.right, hm);
    }

}
