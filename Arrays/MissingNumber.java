class Solution {

    public int missingNumber(int[] nums) {

        int i = 0;
        int n = nums.length;

        while (i < n) {

            int correctIndex = nums[i];

            if (nums[i] < n && nums[i] != nums[correctIndex]) {

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {

            if (nums[i] != i) {
                return i;
            }
        }

        return n;
    }
}
