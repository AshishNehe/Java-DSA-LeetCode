import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    // Time Complexity: O(n * 26)
    // Space Complexity: O(26)

    List<String> commonChars(String[] words) {

        int[] common = new int[26];

        // Count characters in the first word
        for (char c : words[0].toCharArray()) {
            common[c - 'a']++;
        }

        // Find minimum frequency across all words
        for (int i = 1; i < words.length; i++) {

            int[] current = new int[26];

            for (char c : words[i].toCharArray()) {
                current[c - 'a']++;
            }

            // Keep the minimum frequency
            for (int j = 0; j < 26; j++) {
                common[j] = Math.min(common[j], current[j]);
            }
        }

        // Add common characters to the result
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {

            while (common[i] > 0) {
                result.add(String.valueOf((char) ('a' + i)));
                common[i]--;
            }
        }

        return result;
    }
}
