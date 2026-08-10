import java.util.HashMap;

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Check if the number appeared before
            if (map.containsKey(nums[i])) {

                int previousIndex = map.get(nums[i]);

                // Check the distance between the two indices
                if (i - previousIndex <= k) {
                    return true;
                }
            }

            // Store the latest index of the current number
            map.put(nums[i], i);
        }

        return false;
    }
}
