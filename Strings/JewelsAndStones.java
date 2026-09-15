import java.util.HashSet;

public class JewelsAndStones {

    // Time Complexity: O(n + m)
    // Space Complexity: O(n)

    int numJewelsInStones(String jewels, String stones) {

        HashSet<Character> jewelSet = new HashSet<>();

        // Store all jewel characters
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        int count = 0;

        // Check each stone
        for (char c : stones.toCharArray()) {

            if (jewelSet.contains(c)) {
                count++;
            }
        }

        return count;
    }
}
