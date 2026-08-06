class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int minLenWindow = Integer.MAX_VALUE;
        int currentSum = 0;

        int low = 0;
        int high = 0;

        while (high < nums.length) {

            currentSum += nums[high];
            high++;

            while (currentSum >= target) {

                int currentWindowSize = high - low;
                minLenWindow = Math.min(minLenWindow, currentWindowSize);

                currentSum -= nums[low];
                low++;
            }
        }

        return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }
}
