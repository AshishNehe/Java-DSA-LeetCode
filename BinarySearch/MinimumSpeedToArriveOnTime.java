public class MinimumSpeedToArriveOnTime {

    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour <= dist.length - 1) {
            return -1;
        }

        int left = 1;
        int right = 10_000_000;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canArriveOnTime(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canArriveOnTime(int[] dist, double hour, int speed) {
        double time = 0;

        for (int i = 0; i < dist.length; i++) {
            if (i == dist.length - 1) {
                time += (double) dist[i] / speed;
            } else {
                time += Math.ceil((double) dist[i] / speed);
            }

            if (time > hour) {
                return false;
            }
        }

        return true;
    }

    // Time Complexity: O(n log 10^7)
    // Space Complexity: O(1)
}
