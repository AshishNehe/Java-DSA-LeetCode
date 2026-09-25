public class CapacityToShipPackagesWithinDDays {

    // Time Complexity: O(n log(sum(weights)))
    // Space Complexity: O(1)

    public int shipWithinDays(int[] weights, int days) {

        int minCapacity = 0;
        int maxCapacity = 0;

        // Minimum capacity = heaviest package
        // Maximum capacity = total weight
        for (int weight : weights) {
            minCapacity = Math.max(minCapacity, weight);
            maxCapacity += weight;
        }

        while (minCapacity < maxCapacity) {

            int mid = minCapacity
                    + (maxCapacity - minCapacity) / 2;

            int requiredDays = 1;
            int currentWeight = 0;

            // Check how many days are needed
            // with capacity = mid
            for (int weight : weights) {

                if (currentWeight + weight > mid) {
                    requiredDays++;
                    currentWeight = 0;
                }

                currentWeight += weight;
            }

            // Capacity is too small
            if (requiredDays > days) {
                minCapacity = mid + 1;
            } else {
                // Capacity works, try smaller
                maxCapacity = mid;
            }
        }

        return minCapacity;
    }
}
