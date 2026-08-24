public class BackspaceStringCompare {

    // Time Complexity: O(n + m)
    // Space Complexity: O(n + m)

    boolean backspaceCompare(String s, String t) {
        return getActual(s).equals(getActual(t));
    }

    private String getActual(String input) {

        StringBuilder actualString = new StringBuilder();
        int hashCount = 0;

        for (int i = input.length() - 1; i >= 0; i--) {

            // Count backspaces
            if (input.charAt(i) == '#') {
                hashCount++;
            }

            // Skip characters removed by backspace
            else if (hashCount > 0) {
                hashCount--;
            }

            // Keep valid characters
            else {
                actualString.append(input.charAt(i));
            }
        }

        return actualString.reverse().toString();
    }
}
