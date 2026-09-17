public class CheckWhetherTwoStringsAreAlmostEquivalent {

    // Time Complexity: O(n + m)
    // Space Complexity: O(1)

    boolean checkAlmostEquivalent(String word1, String word2) {

        int[] freq = new int[26];

        // Count characters in word1
        for (char c : word1.toCharArray()) {
            freq[c - 'a']++;
        }

        // Subtract characters in word2
        for (char c : word2.toCharArray()) {
            freq[c - 'a']--;
        }

        // Check whether any frequency difference exceeds 3
        for (int i = 0; i < 26; i++) {

            if (freq[i] > 3 || freq[i] < -3) {
                return false;
            }
        }

        return true;
    }
}
