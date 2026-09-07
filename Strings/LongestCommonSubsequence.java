public class LongestCommonSubsequence {

    // Time Complexity: O(m * n)
    // Space Complexity: O(m * n)

    int longestCommonSubsequence(String text1, String text2) {

        // Create DP matrix
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // Compare characters of both strings
        for (int i = 1; i <= text1.length(); i++) {

            for (int j = 1; j <= text2.length(); j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {

                    // Characters match
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {

                    // Take the better result
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Return the result from the last cell
        return dp[text1.length()][text2.length()];
    }
}
