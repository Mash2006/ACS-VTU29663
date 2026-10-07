import java.util.*;

public class Task61_CourseScheduleII {

    static int[] findOrder(int numCourses,
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

        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {

            int course = queue.poll();

            result[index++] = course;

            for (int next : graph.get(course)) {

                indegree[next]--;

                if (indegree[next] == 0)
                    queue.add(next);
            }
        }

        if (index != numCourses)
            return new int[0];

        return result;
    }

    public static void main(String[] args) {

        int numCourses = 2;

        int[][] prerequisites = {
            {1, 0}
        };

        int[] result =
            findOrder(numCourses, prerequisites);

        System.out.println("Course Order:");

        for (int x : result)
            System.out.print(x + " ");
    }
}
