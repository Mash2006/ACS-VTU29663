import java.util.*;

public class Task59_KeysAndRooms {

    static boolean canVisitAllRooms(
            List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            int room = queue.poll();

            for (int key : rooms.get(room)) {

                if (!visited[key]) {
                    visited[key] = true;
                    queue.add(key);
                }
            }
        }

        for (boolean v : visited) {
            if (!v)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());

        System.out.println(
            canVisitAllRooms(rooms)
        );
    }
}
