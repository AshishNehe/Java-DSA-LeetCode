import java.util.Arrays;

public class LongestCommonPrefix {

    // Time Complexity: O(n log n)
    // Space Complexity: O(n)

    String longestCommonPrefix(String[] strs) {

        StringBuilder result = new StringBuilder();

        Arrays.sort(strs);

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        for (int i = 0; i < first.length; i++) {

            if (first[i] != last[i]) {
                break;
            }

            result.append(first[i]);
        }

        return result.toString();
    }
}
