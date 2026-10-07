public class Task66_FloodFill {

    static void dfs(int[][] image, int r, int c,
                    int oldColor, int newColor) {

        if (r < 0 || r >= image.length ||
            c < 0 || c >= image[0].length ||
            image[r][c] != oldColor)
            return;

        image[r][c] = newColor;

        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }

    static int[][] floodFill(
            int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];

        if (oldColor != color)
            dfs(image, sr, sc, oldColor, color);

        return image;
    }

    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int[][] result =
            floodFill(image, 1, 1, 2);

        for (int[] row : result)
            for (int x : row)
                System.out.print(x + " ");

        System.out.println();
    }
}
