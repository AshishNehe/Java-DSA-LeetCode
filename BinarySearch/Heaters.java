
import java.util.Arrays;

public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(heaters);

        int radius = 0;

        for (int house : houses) {

            int left = 0;
            int right = heaters.length - 1;

            // Find the first heater >= house
            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (heaters[mid] >= house) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            int rightDistance = (left < heaters.length)
                    ? heaters[left] - house
                    : Integer.MAX_VALUE;

            int leftDistance = (left > 0)
                    ? house - heaters[left - 1]
                    : Integer.MAX_VALUE;

            int nearestDistance = Math.min(leftDistance, rightDistance);

            radius = Math.max(radius, nearestDistance);
        }

        return radius;
    }

    // Time Complexity: O(h log h + n log h)
    // Space Complexity: O(1) auxiliary space, excluding sorting
}
