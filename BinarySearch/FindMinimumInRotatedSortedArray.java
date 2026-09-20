public class FindMinimumInRotatedSortedArray {

    // Time Complexity: O(log n)
    // Space Complexity: O(1)

    int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
    }
}
