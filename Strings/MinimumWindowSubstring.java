public class MinimumWindowSubstring {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Count required characters in t
        int[] mapT = new int[256];

        for (char ch : t.toCharArray()) {
            mapT[ch]++;
        }

        // Count characters in the current window
        int[] mapS = new int[256];

        String result = "";
        int right = 0;
        int min = Integer.MAX_VALUE;

        // Sliding window: [left, right)
        for (int left = 0; left < s.length(); left++) {

            // Expand the window until it contains all characters of t
            while (right < s.length() && !isDesirable(mapS, mapT)) {
                mapS[s.charAt(right)]++;
                right++;
            }

            // Update the result if the current window is valid and smaller
            if (isDesirable(mapS, mapT) && right - left < min) {
                result = s.substring(left, right);
                min = right - left;
            }

            // Remove the leftmost character before shrinking the window
            mapS[s.charAt(left)]--;
        }

        return result;
    }

    // Check whether the current window contains all required characters
    private boolean isDesirable(int[] mapS, int[] mapT) {

        for (int i = 0; i < 256; i++) {
            if (mapT[i] > mapS[i]) {
                return false;
            }
        }

        return true;
    }
}
