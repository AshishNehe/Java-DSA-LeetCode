import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        // Store character mappings
        Map<Character, Character> charMappingMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if (!charMappingMap.containsKey(original)) {

                // Make sure replacement is not already mapped
                if (!charMappingMap.containsValue(replacement)) {
                    charMappingMap.put(original, replacement);
                } else {
                    return false;
                }

            } else {

                // Check if the existing mapping is correct
                char mappedCharacter = charMappingMap.get(original);

                if (mappedCharacter != replacement) {
                    return false;
                }
            }
        }

        return true;
    }
}
