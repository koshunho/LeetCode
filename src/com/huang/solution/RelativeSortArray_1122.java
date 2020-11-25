package com.huang.solution;

import java.util.*;

/*1122. 数组的相对排序
给你两个数组，arr1 和 arr2，

arr2中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。



示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]


。*/
public class RelativeSortArray_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> arr1List = new ArrayList<>();
        for (int i : arr1) {
            arr1List.add(i);
        }
        int [] ans = new int [arr1.length];
        int index = 0;
        for (int i : arr2) {
            int frequency = Collections.frequency(arr1List, i);
            Arrays.fill(ans, index, index + frequency, i);
            index += frequency;
            while(frequency-- > 0) arr1List.remove((Integer) i); //注意这里，remove(1)相当于删除index为1的位置上元素。remove(Integer(1))相当于删除指定元素的第一个匹配项。第一个!
        }
        Collections.sort(arr1List);
        for(int i = index; i < arr1.length; i++){
            ans[i] = arr1List.get(0);
            arr1List.remove(0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr1 = new int [] {2,3,1,3,2,4,6,7,9,2,19};
        int [] arr2 = new int [] {2,1,4,3,9,6};
        int[] ints = new RelativeSortArray_1122().relativeSortArray(arr1, arr2);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
