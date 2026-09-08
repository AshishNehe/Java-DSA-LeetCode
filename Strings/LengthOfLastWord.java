public class LengthOfLastWord {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    int lengthOfLastWord(String s) {

        int i = s.length() - 1;

        // Ignore spaces at the end
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int length = 0;

        // Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
