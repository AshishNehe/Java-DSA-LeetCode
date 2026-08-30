public class ZigzagConversion {

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    String convert(String s, int numRows) {

        // Create a StringBuilder for each row
        StringBuilder[] sbs = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        char[] arr = s.toCharArray();
        int n = arr.length;
        int index = 0;

        // Traverse the string in zigzag pattern
        while (index < n) {

            // Go down through all rows
            for (int j = 0; j < numRows && index < n; j++) {
                sbs[j].append(arr[index++]);
            }

            // Go up through the middle rows
            for (int j = numRows - 2; j > 0 && index < n; j--) {
                sbs[j].append(arr[index++]);
            }
        }

        // Combine all rows into one string
        StringBuilder res = sbs[0];

        for (int i = 1; i < numRows; i++) {
            res.append(sbs[i].toString());
        }

        return res.toString();
    }
}
