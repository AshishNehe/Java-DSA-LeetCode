public class ValidAnagram {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    boolean isAnagram(String s, String t) {

        // Different lengths cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];

        // Count characters in s
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        // Subtract characters using t
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;
        }

        // All frequencies should be zero
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
