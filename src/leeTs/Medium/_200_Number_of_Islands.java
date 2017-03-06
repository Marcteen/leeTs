package leeTs.Medium;

public class _200_Number_of_Islands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int numIslands(char[][] grid) {
        if(null == grid || 0 == grid.length || 0 == grid[0].length)
            return 0;
        int result = 0;
        for(int i = 0; i < grid.length; i ++)
            for(int j = 0; j < grid[0].length; j ++)
                if('1' == grid[i][j]) {
                    result ++;
                    extendIsland(grid, i, j);
                }
        return result;
                    
    }
    public void extendIsland(char[][] grid, int i, int j) {
        grid[i][j] = 0;
        if(i > 0 && grid[i - 1][j] == '1')
            extendIsland(grid, i - 1, j);
        if(j > 0 && grid[i][j - 1] == '1')
            extendIsland(grid, i, j - 1);
        if(j < grid[0].length - 1 && grid[i][j + 1] == '1')
            extendIsland(grid, i, j + 1);
        if(i < grid.length - 1 && grid[i + 1][j] == '1')
            extendIsland(grid, i + 1, j);
    }
}
