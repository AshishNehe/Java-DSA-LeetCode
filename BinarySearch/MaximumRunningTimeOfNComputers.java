public class MaximumRunningTimeOfNComputers {

    public long maxRunTime(int n, int[] batteries) {
        long totalPower = 0;

        for (int battery : batteries) {
            totalPower += battery;
        }

        long left = 0;
        long right = totalPower / n;

        while (left < right) {
            long mid = left + (right - left + 1) / 2;

            if (canRun(n, batteries, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canRun(int n, int[] batteries, long time) {
        long availablePower = 0;

        for (int battery : batteries) {
            availablePower += Math.min((long) battery, time);

            if (availablePower >= (long) n * time) {
                return true;
            }
        }

        return false;
    }

    // Time Complexity: O(m log(totalPower / n))
    // Space Complexity: O(1)
}
