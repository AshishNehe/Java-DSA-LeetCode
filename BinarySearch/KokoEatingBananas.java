public class KokoEatingBananas {

    // Time Complexity: O(n log(max(piles)))
    // Space Complexity: O(1)

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find the maximum pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int answer = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            long hours = 0;

            // Calculate required hours at speed mid
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
