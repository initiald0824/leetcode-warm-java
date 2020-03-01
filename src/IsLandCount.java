//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
//
//
// 示例 2:
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集
/**
 * @author initiald0824
 * @date 2020/2/17 10:23 下午
 */
public class IsLandCount {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
    public void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        if (i - 1 >= 0)  {
            dfs(grid, i-1, j);
        }
        if (i + 1 < grid.length) {
            dfs(grid,i+1, j);
        }
        if (j - 1 >= 0) {
            dfs(grid, i, j-1);
        }
        if (j + 1 < grid[0].length) {
            dfs(grid, i, j+1);
        }
    }
}
