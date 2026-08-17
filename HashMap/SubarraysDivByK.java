import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(n)
// Space Complexity: O(k)

public class SubarraysDivByK {

    int subarraysDivByK(int[] nums, int k) {

        Map<Integer, Integer> remainderCount = new HashMap<>();

        // Remainder 0 exists before starting
        remainderCount.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            // Keep remainder positive
            int remainder = ((prefixSum % k) + k) % k;

            // Same remainder means the subarray is divisible by k
            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
            }

            // Store the frequency of the remainder
            remainderCount.put(
                remainder,
                remainderCount.getOrDefault(remainder, 0) + 1
            );
        }

        return count;
    }
}
