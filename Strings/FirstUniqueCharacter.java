import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    // Time Complexity: O(n)
    // Space Complexity: O(k)

    int firstUniqueChar(String str) {

        Map<Character, Integer> charFreqMap = new HashMap<>();

        // Count frequency of each character
        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            int freq = charFreqMap.getOrDefault(c, 0);

            charFreqMap.put(c, freq + 1);
        }

        // Find the first character with frequency 1
        for (int i = 0; i < str.length(); i++) {

            if (charFreqMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
