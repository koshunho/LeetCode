package com.huang.solution;

import java.util.*;

public class KthLargest_703 {

    Queue<Integer> pq;

    int k;

    public KthLargest_703(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int [] nums = new int [] {4, 5, 8, 2};
        int k = 3;
        KthLargest_703 kthLargest = new KthLargest_703(k, nums);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            int add = kthLargest.add(i);
            System.out.println(add);
        }
    }
}
