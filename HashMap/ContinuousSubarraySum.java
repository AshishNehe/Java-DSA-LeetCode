import java.util.HashMap;

// Time Complexity: O(n)
// Space Complexity: O(n)

public class ContinuousSubarraySum {

    boolean checkSubarraySum(int[] nums, int k) {

        // Handle k = 0
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 exists before the array starts
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int remainder = sum % k;

            if (map.containsKey(remainder)) {

                // Check for subarray of length at least 2
                if (i - map.get(remainder) >= 2) {
                    return true;
                }

            } else {
                // Store only the first occurrence
                map.put(remainder, i);
            }
        }

        return false;
    }
}
