/*
    Given grid where '1' is land & '0' is water, return number of islands

    DFS, set visited land to true to not visit it again, count islands

    Time: O(m x n)
    Space: O(m x n)
*/

class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numIslands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    numIslands++;
                    dfs(i, j, visited, grid);
                }
            }
        }

        return numIslands;
    }

    private void dfs(int i, int j, boolean[][] visited, char[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(i + 1, j, visited, grid);
        dfs(i - 1, j, visited, grid);
        dfs(i, j + 1, visited, grid);
        dfs(i, j - 1, visited, grid);
    }
}
