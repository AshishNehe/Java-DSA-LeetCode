import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(n)
// Space Complexity: O(n)

public class SubArraySumEqualsK {

    int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);

        int result = 0;
        int prefixSum = 0;

        for (int num : nums) {

            // Calculate the current prefix sum
            prefixSum += num;

            // Check if a previous prefix sum can form sum k
            if (sumCountMap.containsKey(prefixSum - k)) {
                result += sumCountMap.get(prefixSum - k);
            }

            // Store the frequency of the current prefix sum
            sumCountMap.put(
                prefixSum,
                sumCountMap.getOrDefault(prefixSum, 0) + 1
            );
        }

        return result;
    }
}
