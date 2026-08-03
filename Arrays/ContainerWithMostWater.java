class Solution {

    public int maxArea(int[] height) {

        int maxWater = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            int width = right - left;

            int h = Math.min(height[left], height[right]);

            int currentWater = width * h;

            maxWater = Math.max(maxWater, currentWater);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
