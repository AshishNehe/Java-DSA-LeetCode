public class ValidPalindromeII {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        // Compare characters from both ends
        while (left < right) {

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {

                // Skip either left or right character
                return isPalindrome(s, left + 1, right)
                        || isPalindrome(s, left, right - 1);
            }
        }

        return true;
    }

    // Check if the remaining substring is a palindrome
    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}
