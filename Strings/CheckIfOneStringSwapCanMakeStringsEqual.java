public class CheckIfOneStringSwapCanMakeStringsEqual {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    boolean areAlmostEqual(String s1, String s2) {

        int first = -1;
        int second = -1;

        // Find positions where the strings differ
        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {

                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    // More than two differences
                    return false;
                }
            }
        }

        // Strings are already equal
        if (first == -1) {
            return true;
        }

        // Only one difference cannot be fixed with a swap
        if (second == -1) {
            return false;
        }

        // Check whether swapping fixes both positions
        return s1.charAt(first) == s2.charAt(second)
                && s1.charAt(second) == s2.charAt(first);
    }
}
