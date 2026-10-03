import java.util.*;

public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;

        // Store {start, original index}
        int[][] starts = new int[n][2];

        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        // Sort by start value
        Arrays.sort(starts, (a, b) -> a[0] - b[0]);

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {

            int target = intervals[i][1];

            int left = 0;
            int right = n - 1;
            int result = -1;

            // Find the first start >= target
            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (starts[mid][0] >= target) {
                    result = starts[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            answer[i] = result;
        }

        return answer;
    }

    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
}
