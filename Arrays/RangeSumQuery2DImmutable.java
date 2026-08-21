// Time Complexity: O(m * n) for construction
// Each sumRegion query: O(1)
// Space Complexity: O(m * n)

public class RangeSumQuery2DImmutable {

    private int[][] prefix;

    public RangeSumQuery2DImmutable(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // Extra row and column make boundary calculations easier
        prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // 2D prefix sum using inclusion-exclusion
                prefix[i][j] =
                    matrix[i - 1][j - 1]
                    + prefix[i - 1][j]
                    + prefix[i][j - 1]
                    - prefix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        // Calculate the required rectangle sum
        return prefix[row2 + 1][col2 + 1]
             - prefix[row1][col2 + 1]
             - prefix[row2 + 1][col1]
             + prefix[row1][col1];
    }
}
