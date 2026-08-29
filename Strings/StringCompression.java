public class StringCompression {

    // Time Complexity: O(n)
    // Space Complexity: O(log n)

    int compress(char[] chars) {

        int i = 0;
        int idx = 0;

        while (i < chars.length) {

            int j = i;

            // Find the end of the current group
            while (j < chars.length && chars[i] == chars[j]) {
                j++;
            }

            // Store the current character
            chars[idx++] = chars[i];

            int len = j - i;

            // Directly store single-digit counts
            if (len > 1 && len < 10) {
                chars[idx++] = (char) ('0' + len);
            }

            // Store each digit separately for multi-digit counts
            else if (len >= 10) {

                String count = String.valueOf(len);

                for (char c : count.toCharArray()) {
                    chars[idx++] = c;
                }
            }

            // Move to the next group
            i = j;
        }

        return idx;
    }
}
