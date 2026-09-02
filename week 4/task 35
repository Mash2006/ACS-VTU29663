import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] frequency = new int[26];

        for (char task : tasks) {
            frequency[task - 'A']++;
        }

        Arrays.sort(frequency);

        int maxFrequency = frequency[25];

        int intervals = (maxFrequency - 1) * (n + 1);

        int i = 25;

        while (i >= 0 && frequency[i] == maxFrequency) {
            intervals++;
            i--;
        }

        return Math.max(intervals, tasks.length);
    }
}
