import java.util.*;

public class Task62_SortItemsByGroupsRespectingDependencies {

    static List<Integer> topologicalSort(
            int n, List<List<Integer>> graph,
            int[] indegree) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();
            result.add(node);

            for (int next : graph.get(node)) {

                indegree[next]--;

                if (indegree[next] == 0)
                    queue.add(next);
            }
        }

        return result.size() == n ? result : new ArrayList<>();
    }

    public static void main(String[] args) {

        System.out.println(
            "Task 62: Sort Items by Groups Respecting Dependencies"
        );
        System.out.println(
            "Use topological sorting on groups and items."
        );
    }
}
