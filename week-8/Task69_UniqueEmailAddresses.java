import java.util.*;

public class Task69_UniqueEmailAddresses {

    static int numUniqueEmails(String[] emails) {

        Set<String> unique = new HashSet<>();

        for (String email : emails) {

            String[] parts = email.split("@");

            String local = parts[0];

            int plus = local.indexOf('+');

            if (plus != -1)
                local = local.substring(0, plus);

            local = local.replace(".", "");

            unique.add(local + "@" + parts[1]);
        }

        return unique.size();
    }

    public static void main(String[] args) {

        String[] emails = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob@leetcode.com",
            "testemail@leetcode.com"
        };

        System.out.println(
            "Unique Emails = " +
            numUniqueEmails(emails)
        );
    }
}
