import java.util.*;

public class Task67_AccountsMerge {

    static List<List<String>> accountsMerge(
            List<List<String>> accounts) {

        Map<String, String> parent = new HashMap<>();
        Map<String, String> owner = new HashMap<>();

        for (List<String> account : accounts) {

            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {

                String email = account.get(i);

                parent.putIfAbsent(email, email);
                owner.put(email, name);

                union(parent, account.get(1), email);
            }
        }

        Map<String, TreeSet<String>> groups =
                new HashMap<>();

        for (String email : parent.keySet()) {

            String root = find(parent, email);

            groups
                .computeIfAbsent(root,
                    k -> new TreeSet<>())
                .add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (String root : groups.keySet()) {

            List<String> list = new ArrayList<>();

            list.add(owner.get(root));
            list.addAll(groups.get(root));

            result.add(list);
        }

        return result;
    }

    static String find(
            Map<String, String> parent, String x) {

        if (!parent.get(x).equals(x))
            parent.put(x,
                find(parent, parent.get(x)));

        return parent.get(x);
    }

    static void union(
            Map<String, String> parent,
            String a, String b) {

        parent.put(find(parent, a), find(parent, b));
    }

    public static void main(String[] args) {

        System.out.println(
            "Task 67: Accounts Merge"
        );
    }
}
