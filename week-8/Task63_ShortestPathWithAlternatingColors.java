import java.util.*;

public class Task63_ShortestPathWithAlternatingColors {

    static int[] shortestAlternatingPaths(
            int n, int[][] redEdges, int[][] blueEdges) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : redEdges)
            graph[e[0]].add(new int[]{e[1], 0});

        for (int[] e : blueEdges)
            graph[e[0]].add(new int[]{e[1], 1});

        int[] answer = new int[n];

        Arrays.fill(answer, -1);

        boolean[][] visited = new boolean[n][2];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        queue.add(new int[]{0, 1});

        visited[0][0] = true;
        visited[0][1] = true;

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] current = queue.poll();

                int node = current[0];
                int color = current[1];

                if (answer[node] == -1)
                    answer[node] = distance;

                for (int[] next : graph[node]) {

                    if (next[1] != color &&
                        !visited[next[0]][next[1]]) {

                        visited[next[0]][next[1]] = true;

                        queue.add(
                            new int[]{next[0], next[1]}
                        );
                    }
                }
            }

            distance++;
        }

        return answer;
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] red = {{0, 1}};
        int[][] blue = {{1, 2}};

        System.out.println(
            Arrays.toString(
                shortestAlternatingPaths(n, red, blue)
            )
        );
    }
}
