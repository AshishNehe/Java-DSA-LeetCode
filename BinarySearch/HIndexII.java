public class HIndexII {

    public int hIndex(int[] citations) {

        int n = citations.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int papers = n - mid;

            if (citations[mid] >= papers) {
                // Current h-index is valid.
                // Search left for a larger h-index.
                right = mid - 1;
            } else {
                // Not enough citations.
                left = mid + 1;
            }
        }

        return n - left;
    }

    // Time Complexity: O(log n)
    // Space Complexity: O(1)
}
