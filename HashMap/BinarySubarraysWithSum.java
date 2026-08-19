import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(n)
// Space Complexity: O(n)

public class BinarySubarraysWithSum {

    int numSubarraysWithSum(int[] nums, int goal) {

        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            // Calculate prefix sum
            prefixSum += num;

            // Check if a previous prefix sum can form the goal
            if (prefixCount.containsKey(prefixSum - goal)) {
                count += prefixCount.get(prefixSum - goal);
            }

            // Store frequency of current prefix sum
            prefixCount.put(
                prefixSum,
                prefixCount.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }
}
