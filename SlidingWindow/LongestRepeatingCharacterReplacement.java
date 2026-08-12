import java.util.Arrays;

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character to the window
            freq[s.charAt(right) - 'A']++;

            // Track the most frequent character
            maxFreq = Math.max(
                maxFreq,
                freq[s.charAt(right) - 'A']
            );

            int windowLength = right - left + 1;

            // Shrink if more than k replacements are needed
            if (windowLength - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            windowLength = right - left + 1;
            maxWindow = Math.max(maxWindow, windowLength);
        }

        return maxWindow;
    }
}
