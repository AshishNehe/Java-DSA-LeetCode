public class RansomNote {

    // Time Complexity: O(n + m)
    // Space Complexity: O(1)

    boolean canConstruct(String ransomNote, String magazine) {

        int[] charCount = new int[26];

        // Count the frequency of characters in magazine
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Check if ransomNote has enough characters
        for (char c : ransomNote.toCharArray()) {

            if (charCount[c - 'a'] == 0) {
                return false;
            } else {
                charCount[c - 'a']--;
            }
        }

        return true;
    }
}
