public class SumAbsoluteDifferences {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        long total = 0;

        for (int num : nums) {
            total += num;
        }

        long prefix = 0;

        for (int i = 0; i < n; i++) {
            long left = (long) nums[i] * i - prefix;

            long right = (total - prefix - nums[i])
                    - (long) nums[i] * (n - i - 1);

            result[i] = (int) (left + right);
            prefix += nums[i];
        }

        return result;
    }
}
