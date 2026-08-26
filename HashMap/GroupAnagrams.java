import java.util.*;

public class GroupAnagrams {

    // Time Complexity: O(N × K)
    // Space Complexity: O(N × K)

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            String key = getFrequencyString(str);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }

    private String getFrequencyString(String str) {

        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder key = new StringBuilder();

        char c = 'a';

        for (int count : freq) {
            key.append(c);
            key.append(count);
            c++;
        }

        return key.toString();
    }
}
