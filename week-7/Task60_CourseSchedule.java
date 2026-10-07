import java.util.*;

public class Task60_CourseSchedule {

    static boolean canFinish(int numCourses,
                             int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {

            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int completed = 0;

        while (!queue.isEmpty()) {

            int course = queue.poll();
            completed++;

            for (int next : graph.get(course)) {

                indegree[next]--;

                if (indegree[next] == 0)
                    queue.add(next);
            }
        }

        return completed == numCourses;
    }

    public static void main(String[] args) {

        int numCourses = 2;

        int[][] prerequisites = {
            {1, 0}
        };

        System.out.println(
            "Can finish courses = " +
            canFinish(numCourses, prerequisites)
        );
    }
}
