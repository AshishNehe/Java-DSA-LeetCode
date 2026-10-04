public class MinimumLimitOfBallsInABag {

    public int minimumSize(int[] nums, int maxOperations) {

        int left = 1;
        int right = 0;

        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canSplit(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canSplit(int[] nums, int maxOperations, int maxBalls) {

        int operations = 0;

        for (int balls : nums) {

            operations += (balls - 1) / maxBalls;

            if (operations > maxOperations) {
                return false;
            }
        }

        return true;
    }

    // Time Complexity: O(n log M)
    // Space Complexity: O(1)
}
