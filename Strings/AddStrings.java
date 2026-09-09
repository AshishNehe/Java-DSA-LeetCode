public class AddStrings {

    // Time Complexity: O(max(n, m))
    // Space Complexity: O(max(n, m))

    String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;

        StringBuilder result = new StringBuilder();

        // Add digits from right to left
        while (i >= 0 || j >= 0 || carry != 0) {

            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;

            result.append(sum % 10);

            carry = sum / 10;

            i--;
            j--;
        }

        // Digits were added from right to left
        return result.reverse().toString();
    }
}
