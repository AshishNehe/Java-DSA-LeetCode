package leetcode.medium;

public class ReverseWordsInAString {

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    String reverseWords(String s) {

        String[] arr = s.split(" ");

        StringBuilder res = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {

            // Skip empty strings caused by multiple spaces
            if (arr[i].length() == 0) {
                continue;
            }

            if (res.length() == 0) {
                res.append(arr[i]);
            } else {
                res.append(" ");
                res.append(arr[i]);
            }
        }

        return res.toString();
    }
}
