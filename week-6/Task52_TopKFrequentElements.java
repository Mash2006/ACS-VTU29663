import java.util.*;

public class Task52_TopKFrequentElements {

    static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num,
                    frequency.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>(
                    (a, b) -> frequency.get(a) - frequency.get(b)
                );

        for (int num : frequency.keySet()) {

            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};

        int k = 2;

        int[] result = topKFrequent(nums, k);

        System.out.println("Top " + k + " Frequent Elements:");

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
