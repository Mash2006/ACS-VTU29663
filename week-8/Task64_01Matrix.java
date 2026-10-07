import java.util.*;

public class Task64_01Matrix {

    static int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 0)
                    queue.add(new int[]{i, j});
                else
                    mat[i][j] = -1;
            }
        }

        int[][] dir = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            for (int[] d : dir) {

                int r = current[0] + d[0];
                int c = current[1] + d[1];

                if (r >= 0 && r < rows &&
                    c >= 0 && c < cols &&
                    mat[r][c] == -1) {

                    mat[r][c] = mat[current[0]][current[1]] + 1;

                    queue.add(new int[]{r, c});
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };

        int[][] result = updateMatrix(matrix);

        for (int[] row : result)
            System.out.println(Arrays.toString(row));
    }
}
