public class Task58_MaxAreaOfIsland {

    static int dfs(int[][] grid, int r, int c) {

        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] == 0) {

            return 0;
        }

        grid[r][c] = 0;

        return 1
            + dfs(grid, r + 1, c)
            + dfs(grid, r - 1, c)
            + dfs(grid, r, c + 1)
            + dfs(grid, r, c - 1);
    }

    static int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    maxArea = Math.max(
                        maxArea,
                        dfs(grid, i, j)
                    );
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {0, 0, 1, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0}
        };

        System.out.println(
            "Maximum Area = " +
            maxAreaOfIsland(grid)
        );
    }
}
