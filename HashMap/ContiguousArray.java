import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(n)
// Space Complexity: O(n)

public class ContiguousArray {

    int findMaxLength(int[] nums) {

        int sum = 0;
        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 exists before the array starts
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            // Treat 0 as -1 and 1 as +1
            sum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {

                // Same prefix sum means equal 0s and 1s
                maxLength = Math.max(maxLength, i - map.get(sum));

            } else {

                // Store only the first occurrence
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
