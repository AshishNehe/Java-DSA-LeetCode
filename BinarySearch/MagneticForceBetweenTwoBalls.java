import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        int left = 1;
        int right = position[position.length - 1] - position[0];

        int answer = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canPlaceBalls(position, m, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canPlaceBalls(int[] position, int m, int distance) {

        int ballsPlaced = 1;
        int lastPosition = position[0];

        for (int i = 1; i < position.length; i++) {

            if (position[i] - lastPosition >= distance) {

                ballsPlaced++;
                lastPosition = position[i];

                if (ballsPlaced == m) {
                    return true;
                }
            }
        }

        return false;
    }

    // Time Complexity: O(n log n + n log(maxPosition - minPosition))
    // Space Complexity: O(log n) due to sorting
}
