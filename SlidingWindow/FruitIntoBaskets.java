import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> basket = new HashMap<>();

        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {

            // Add the current fruit to the window
            int currentCount = basket.getOrDefault(fruits[right], 0);
            basket.put(fruits[right], currentCount + 1);

            // Shrink the window until only 2 fruit types remain
            while (basket.size() > 2) {

                int fruitCount = basket.get(fruits[left]);

                if (fruitCount == 1) {
                    basket.remove(fruits[left]);
                } else {
                    basket.put(fruits[left], fruitCount - 1);
                }

                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
