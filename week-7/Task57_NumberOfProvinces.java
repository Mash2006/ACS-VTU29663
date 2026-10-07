public class Task57_NumberOfProvinces {

    static void dfs(int[][] graph, boolean[] visited, int node) {

        visited[node] = true;

        for (int i = 0; i < graph.length; i++) {

            if (graph[node][i] == 1 &&
                !visited[i]) {

                dfs(graph, visited, i);
            }
        }
    }

    static int findCircleNum(int[][] graph) {

        int n = graph.length;
        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                provinces++;
                dfs(graph, visited, i);
            }
        }

        return provinces;
    }

    public static void main(String[] args) {

        int[][] graph = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        System.out.println(
            "Number of Provinces = " +
            findCircleNum(graph)
        );
    }
}
