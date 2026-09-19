public class SqrtX {

    // Time Complexity: O(log x)
    // Space Complexity: O(1)

    int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        int result = 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            long squared = (long) mid * mid;

            if (squared == x) {
                return mid;
            } else if (squared > x) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        return result;
    }
}
