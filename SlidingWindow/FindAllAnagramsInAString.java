import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        List<Integer> result = new ArrayList<>();

        // Count characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Maintain a window of size p.length()
        for (int i = 0; i < s.length(); i++) {

            // Add the current character
            sCount[s.charAt(i) - 'a']++;

            // Remove the character leaving the window
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // If frequencies match, an anagram is found
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
