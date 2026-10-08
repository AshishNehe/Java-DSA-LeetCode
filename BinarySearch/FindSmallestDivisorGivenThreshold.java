public class FindSmallestDivisorGivenThreshold {

    public int smallestDivisor(int[] nums, int threshold) {

        int left = 1;
        int right = 0;

        // Find maximum value
        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (isValid(nums, threshold, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isValid(int[] nums, int threshold, int divisor) {

        int sum = 0;

        for (int num : nums) {

            // Ceiling division
            sum += (num + divisor - 1) / divisor;

            if (sum > threshold) {
                return false;
            }
        }

        return true;
    }

    // Time Complexity: O(n log M)
    // Space Complexity: O(1)
}
