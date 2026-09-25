public class SingleElementInASortedArray {

    // Time Complexity: O(log n)
    // Space Complexity: O(1)

    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            // Correct pair
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                // Pair is broken
                right = mid;
            }
        }

        return nums[left];
    }
}
