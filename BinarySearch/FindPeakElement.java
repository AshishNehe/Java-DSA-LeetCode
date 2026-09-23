public class FindPeakElement {

    // Time Complexity: O(log n)
    // Space Complexity: O(1)

    int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Peak exists on the right side
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                // Peak is at mid or on the left side
                right = mid;
            }
        }

        return left;
    }
}
