package com.huang.solution;

import java.util.LinkedList;

/*994. 腐烂的橘子
* 在给定的网格中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
* 示例 1：

输入：[[2,1,1],[1,1,0],[0,1,1]]
输出：4

* 示例 2：

输入：[[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。

* 示例 3：

输入：[[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 

提示：

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] 仅为 0、1 或 2
*/

// BFS 还是不太熟，得多做几题练练
public class OrangesRotting_994 {
    class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        LinkedList<Coordinate> queue = new LinkedList();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.addLast(new Coordinate(i, j));
                }
            }
        }

        int step = 0;
        int [] dx = new int [] {1,-1,0,0};
        int [] dy = new int [] {0,0,1,-1};
        while(!queue.isEmpty()){
            int count = 0;    //记录同一批入队的时候的元素的遍历完没有。遍历完同一批入队的元素才step++
            int size = queue.size();
            while(count < size){
                count++;
                Coordinate cur = queue.removeFirst();
                for(int i = 0; i < 4; i++){
                    int x = cur.x + dx[i], y = cur.y + dy[i];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        queue.addLast(new Coordinate(x, y));
                    }
                }
            }
            if(!queue.isEmpty()) step++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int [][] grid = new int [][]{{2,1,1},{1,1,0},{0,1,1}};

        int ret = new OrangesRotting_994().orangesRotting(grid);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}
