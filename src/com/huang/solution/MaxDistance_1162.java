package com.huang.solution;
/*1162. 地图分析
* 你现在手里有一份大小为 N x N 的「地图」（网格） grid，上面的每个「区域」（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。

我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。

如果我们的地图上只有陆地或者海洋，请返回 -1。

 

示例 1：



输入：[[1,0,1],[0,0,0],[1,0,1]]
输出：2
解释：
海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
示例 2：



输入：[[1,0,0],[0,0,0],[0,0,0]]
输出：4
解释：
海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 

提示：

1 <= grid.length == grid[0].length <= 100
grid[i][j] 不是 0 就是 1

*/

// 感觉这题应该是简单题吧。。。。
import java.util.ArrayList;
import java.util.List;

public class MaxDistance_1162 {
    class Land{
        int i;
        int j;
        public Land(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public int maxDistance(int[][] grid) {
        int max = -1;

        List<Land> landList = new ArrayList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    landList.add(new Land(i,j));
                }
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    int curMin = Integer.MAX_VALUE;
                    for(Land land : landList){
                        int distance = Math.abs(land.i - i) + Math.abs(land.j - j);
                        curMin = Math.min(curMin, distance);
                    }
                    max = Math.max(max, curMin);
                }
            }
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }

    public static void main(String[] args) {
        int [][] grid = new int [][] {
                {1,0,0},
                {0,0,0},
                {0,0,0}};

        int ret = new MaxDistance_1162().maxDistance(grid);

        System.out.println(ret);
    }
}
