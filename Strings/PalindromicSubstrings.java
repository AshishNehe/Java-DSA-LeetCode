public class PalindromicSubstrings {

    // Time Complexity: O(n²)
    // Space Complexity: O(1)

    int countSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // Count odd-length palindromes
            count += countPalindromes(s, i, i);

            // Count even-length palindromes
            count += countPalindromes(s, i, i + 1);
        }

        return count;
    }

    private int countPalindromes(String s, int left, int right) {

        int count = 0;

        // Expand around the center
        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            count++;
            left--;
            right++;
        }

        return count;
    }
}
