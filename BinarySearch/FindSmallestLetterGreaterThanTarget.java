public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Wrap around if no greater letter exists
        return letters[left % letters.length];
    }

    // Time Complexity: O(log n)
    // Space Complexity: O(1)
}
