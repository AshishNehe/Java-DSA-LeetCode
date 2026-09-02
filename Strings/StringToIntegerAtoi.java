public class StringToIntegerAtoi {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    int myAtoi(String s) {

        int i = 0;

        // Ignore leading whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Determine the sign
        boolean negative = false;

        if (i < s.length() && s.charAt(i) == '+') {
            i++;
        } else if (i < s.length() && s.charAt(i) == '-') {
            negative = true;
            i++;
        }

        // Extract digits
        long result = 0;

        while (i < s.length()
                && s.charAt(i) >= '0'
                && s.charAt(i) <= '9') {

            int digit = s.charAt(i) - '0';

            result = result * 10 + digit;

            // Check overflow
            if (!negative && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (negative && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        // Apply sign
        return negative ? (int) -result : (int) result;
    }
}
