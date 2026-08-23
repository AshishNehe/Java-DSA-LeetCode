public class IsSubsequence {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {

            // If characters match, move to the next character of s
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            // Always move through t
            j++;
        }

        return i == s.length();
    }
}
