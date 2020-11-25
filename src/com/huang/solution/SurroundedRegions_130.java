package com.huang.solution;

/*130. 被围绕的区域
给定一个二维的矩阵，包含'X'和'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
*/

// 应该算是简单题
// 先扫描一遍,让在edge的 'O' 和他连续的'O' 先变成其他其他字符保护他
// 然后再扫一遍,让剩余的'O' 变成'X'
// 最后把第一步的'O'(此刻是其他字符) 恢复回来就OK了
public class SurroundedRegions_130 {

    int [] dx = new int [] {1, 0, -1, 0};
    int [] dy = new int [] {0, -1, 0, 1};

    public void surroundedRegions(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length -1) && board[i][j] == 'O'){
                    helper(board, i, j);
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void helper(char[][] board, int i , int j){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != 'O') return;

        board[i][j] = '*';

        for (int k = 0; k < 4; k++) {
            helper(board, i + dx[k], j + dy[k]);
        }
    }

    public static void main(String[] args) {
        char [][] board = new char [][] {
                {'X','X','X','X'},
                {'X','X','O','X'},
                {'O','O','X','X'},
                {'O','X','X','X'}};

        new SurroundedRegions_130().surroundedRegions(board);

        for (char[] chars : board) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
