public class KthMissingPositiveNumber {

    // Time Complexity: O(log n)
    // Space Complexity: O(1)

    public int findKthPositive(int[] arr, int k) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Count missing numbers before arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + k;
    }
}
