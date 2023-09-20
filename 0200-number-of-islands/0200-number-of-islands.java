/*
This approach is DFS, premium solution also has BFS and Union find way of solving this:

Time complexity : O(M×N) where M is the number of rows and N is the number of columns.

Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
*/

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i<grid.length;i++) {
            for(int j= 0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count ++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i<0 || j<0 || j>=grid[0].length || i>=grid.length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i-1, j);
    }
}