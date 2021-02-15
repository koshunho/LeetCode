package com.huang.solution;

import java.util.HashMap;
import java.util.Map;

public class FindCircleNum_547 {

    private static class Union {
        private Map<Integer, Integer> father;

        private int numOfSets;

        public Union() {
            father = new HashMap<>();

            numOfSets = 0;
        }

        public void add(int x) {
            if (!father.containsKey(x)) {
                father.put(x, null);
                numOfSets++;
            }
        }

        public void merge(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                father.put(rootX, rootY);
                numOfSets--;
            }

        }

        public int find(int x) {
            int root = x;

            while (father.get(root) != null) {
                root = father.get(root);
            }

            if (x != root) {
                father.put(x, root);
            }

            return root;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int getNumOfSets() {
            return numOfSets;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        Union union = new Union();
        for (int i = 0; i < isConnected.length; i++) {
            union.add(i);
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    union.merge(i, j);
                }
            }
        }
        return union.getNumOfSets();
    }
}
