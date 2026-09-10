public class RomanToInteger {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    int romanToInt(String s) {

        int result = 0;

        // Check each Roman numeral
        for (int i = 0; i < s.length(); i++) {

            int current = getValue(s.charAt(i));

            // Subtract when a smaller value comes before a larger value
            if (i + 1 < s.length()
                    && current < getValue(s.charAt(i + 1))) {

                result -= current;

            } else {

                result += current;
            }
        }

        return result;
    }

    // Return the integer value of a Roman numeral
    private int getValue(char c) {

        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }

        return 0;
    }
}
