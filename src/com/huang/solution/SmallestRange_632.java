package com.huang.solution;

import java.util.*;

/*632. 最小区间
你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。

我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。

示例 1:

输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
输出: [20,24]
解释:
列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
注意:

给定的列表可能包含重复元素，所以在这里升序表示 >= 。
1 <= k <= 3500
-105 <= 元素的值 <= 105
*/

//思路：合并K个链表！
// https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/solution/xin-ping-zhuang-jiu-jiu-zhe-ti-jiu-shi-he-bing-kge/
public class SmallestRange_632 {

    private class Node{
        int val;

        int arr;

        int index;

        public Node(int val,int arr, int index) {
            this.val = val;
            this.arr = arr;
            this.index = index;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        // 特别注意这里！ 如果直接是MIN_VALUE或者MAX_VALUE 后面 end - start时直接超出Integer的范围
        int start = Integer.MIN_VALUE / 2;
        int end = Integer.MAX_VALUE / 2;
        int max = Integer.MIN_VALUE;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for(int i = 0; i < nums.size(); i++){
            Integer head = nums.get(i).get(0);

            pq.add(new Node(head, i, 0));

            max = Math.max(max, head);
        }

        while(pq.size() == nums.size()){
            Node minNode = pq.poll();

            if(max - minNode.val < end - start){
                start = minNode.val;
                end = max;
            }

            if(minNode.index + 1 < nums.get(minNode.arr).size()){
                int val = nums.get(minNode.arr).get(minNode.index + 1);
                pq.add(new Node(val, minNode.arr, minNode.index + 1));
                max = Math.max(max, val);
            }
        }
        return new int [] {start, end};
    }

    public static void main(String[] args) {
        Integer [][] arr = new Integer[][]{{4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}};

        List<List<Integer>> nums = new ArrayList<>();

        for (Integer[] num : arr) {
            nums.add(Arrays.asList(num));
        }

        int[] ret = new SmallestRange_632().smallestRange(nums);

        for (int i : ret) {
            System.out.print(i + " ");
        }
    }
}
