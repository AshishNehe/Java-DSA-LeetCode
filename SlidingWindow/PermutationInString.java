import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // Store character frequencies of s1
        int[] s1Freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        int windowSize = s1.length();
        int[] windowFreq = new int[26];

        // Create the first window in s2
        for (int i = 0; i < windowSize; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Check the first window
        if (Arrays.equals(s1Freq, windowFreq)) {
            return true;
        }

        // Slide the window through s2
        for (int right = windowSize; right < s2.length(); right++) {

            // Remove the character leaving the window
            windowFreq[s2.charAt(right - windowSize) - 'a']--;

            // Add the new character entering the window
            windowFreq[s2.charAt(right) - 'a']++;

            // Check if the current window is a permutation of s1
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }
}
