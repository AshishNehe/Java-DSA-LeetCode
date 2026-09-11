public class FindTheDifference {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    char findTheDifference(String s, String t) {

        int[] freq = new int[26];

        // Count characters in s
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Remove characters found in t
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;

            // Extra character found
            if (freq[c - 'a'] < 0) {
                return c;
            }
        }

        return ' ';
    }
}
