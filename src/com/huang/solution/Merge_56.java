package com.huang.solution;

import java.util.*;

/*56. 合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
*/

// 定义一个Interval类，包含区间的start和end。
// 先将每个区间按照左边的大小按照升序排列。
// 再创建一个队列，先将排序后的第一个区间放进队列，然后再依次遍历每个期间。
// 判断两个区间能不能合并的标准就是看当前遍历到的区间的左边 是否大于 队列最后一个区间的右边。
// 如果大于，说明不能合并，直接放进队列。
// 反之，可以合并，就让队列最后一个区间的右边取较大的值。
public class Merge_56 {
     class Interval{
        int start;
        int end;
        Interval(int [] interval){
            this.start = interval[0];
            this.end = interval[1];
        }
        int [] toArray(){
            return new int [] {this.start, this.end};
        }
     }

    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList();
        for(int [] interval: intervals) intervalList.add(new Interval(interval));
        Collections.sort(intervalList, (o1, o2) -> o1.start - o2.start);
        LinkedList<Interval> ans = new LinkedList();
        for(Interval interval: intervalList){
            if(ans.isEmpty() || interval.start > ans.getLast().end){
                ans.add(interval);
            }
            else{
                ans.getLast().end = Math.max(ans.getLast().end, interval.end);
            }
        }
        int [][] res = new int [ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i).toArray();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int [][] {{1,3},{2,6},{8,10},{15,18}};

        int[][] ret = new Merge_56().merge(intervals);

        String out = int2dArrayToString(ret);

        System.out.print(out);
    }

    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            sb.append("[");
            for(int i : item){
                sb.append(i);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("]");
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
