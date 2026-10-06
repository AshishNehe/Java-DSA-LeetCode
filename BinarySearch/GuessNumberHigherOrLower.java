public class GuessNumberHigherOrLower {

    private int pick;

    public GuessNumberHigherOrLower(int pick) {
        this.pick = pick;
    }

    private int guess(int num) {

        if (num > pick) {
            return -1;
        } else if (num < pick) {
            return 1;
        }

        return 0;
    }

    public int guessNumber(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    // Time Complexity: O(log n)
    // Space Complexity: O(1)
}
