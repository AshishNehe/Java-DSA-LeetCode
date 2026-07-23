class Solution {

    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        int idx = nums.length - 1;

        while (left <= right) {

            if (Math.abs(nums[left]) > Math.abs(nums[right])) {

                result[idx] = nums[left] * nums[left];
                left++;

            } else {

                result[idx] = nums[right] * nums[right];
                right--;
            }

            idx--;
        }

        return result;
    }
}
