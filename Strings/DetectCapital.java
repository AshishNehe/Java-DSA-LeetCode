public class DetectCapital {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    boolean detectCapitalUse(String word) {

        int caps = 0;

        // Count uppercase letters
        for (char ch : word.toCharArray()) {

            if (ch >= 'A' && ch <= 'Z') {
                caps++;
            }
        }

        // All lowercase
        if (caps == 0) {
            return true;
        }

        // All uppercase
        if (caps == word.length()) {
            return true;
        }

        // Only the first letter is uppercase
        if (caps == 1
                && word.charAt(0) >= 'A'
                && word.charAt(0) <= 'Z') {
            return true;
        }

        return false;
    }
}
