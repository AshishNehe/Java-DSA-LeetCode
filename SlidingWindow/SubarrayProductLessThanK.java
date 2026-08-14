// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }

        int start = 0;
        int product = 1;
        int count = 0;

        for (int end = 0; end < nums.length; end++) {

            // Add current element to the window
            product *= nums[end];

            // Shrink the window until product becomes less than k
            while (product >= k) {
                product /= nums[start];
                start++;
            }

            // Count valid subarrays ending at end
            count += end - start + 1;
        }

        return count;
    }
}
