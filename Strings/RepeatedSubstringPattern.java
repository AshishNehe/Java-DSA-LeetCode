public class RepeatedSubstringPattern {

    // Time Complexity: O(n²)
    // Space Complexity: O(n)

    boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        // Try every possible pattern length
        for (int l = n / 2; l >= 1; l--) {

            // Pattern length must divide the string length
            if (n % l == 0) {

                int times = n / l;
                String pattern = s.substring(0, l);

                StringBuilder newStr = new StringBuilder();

                // Repeat the pattern
                while (times-- > 0) {
                    newStr.append(pattern);
                }

                // Check if the repeated pattern forms the original string
                if (newStr.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }
}
