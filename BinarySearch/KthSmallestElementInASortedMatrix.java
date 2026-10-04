public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right) {

            int mid = left + (right - left) / 2;

            int count = countLessOrEqual(matrix, mid);

            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int countLessOrEqual(int[][] matrix, int target) {

        int count = 0;

        for (int[] row : matrix) {

            int left = 0;
            int right = row.length - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (row[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            count += left;
        }

        return count;
    }

    // Time Complexity: O(n log n log(max - min))
    // Space Complexity: O(1)
}
