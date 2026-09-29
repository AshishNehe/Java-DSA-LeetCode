public class MinimumNumberOfDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {

        int bouquets = 0;
        int consecutiveFlowers = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {
                consecutiveFlowers++;

                if (consecutiveFlowers == k) {
                    bouquets++;
                    consecutiveFlowers = 0;

                    if (bouquets == m) {
                        return true;
                    }
                }
            } else {
                consecutiveFlowers = 0;
            }
        }

        return false;
    }

    // Time Complexity: O(n log(maxDay - minDay))
    // Space Complexity: O(1)
}
