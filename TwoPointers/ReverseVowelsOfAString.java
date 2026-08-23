public class ReverseVowelsOfAString {

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {

            // Find a vowel from the left
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }

            // Find a vowel from the right
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }

            // Swap the vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}
