import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxVowels(String s, int k) {

        int maxVowels = 0;
        int windowVowels = 0;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                windowVowels++;
            }
        }

        maxVowels = windowVowels;

        // Slide the window
        for (int i = k; i < s.length(); i++) {

            // Remove the character leaving the window
            if (vowels.contains(s.charAt(i - k))) {
                windowVowels--;
            }

            // Add the character entering the window
            if (vowels.contains(s.charAt(i))) {
                windowVowels++;
            }

            maxVowels = Math.max(maxVowels, windowVowels);
        }

        return maxVowels;
    }
}
