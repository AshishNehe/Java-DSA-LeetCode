public class PeakIndexInMountainArray {

    // Time Complexity: O(log n)
    // Space Complexity: O(1)

    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Increasing side
                left = mid + 1;
            } else {
                // Decreasing side
                right = mid;
            }
        }

        return left;
    }
}
