
public class OnlineElection {

    private int[] times;
    private int[] leaders;

    public OnlineElection(int[] persons, int[] times) {

        this.times = times;

        int n = persons.length;
        leaders = new int[n];

        int[] votes = new int[n + 1];
        int leader = -1;
        int maxVotes = 0;

        for (int i = 0; i < n; i++) {

            int person = persons[i];
            votes[person]++;

            // Most recent vote wins ties
            if (votes[person] >= maxVotes) {
                leader = person;
                maxVotes = votes[person];
            }

            leaders[i] = leader;
        }
    }

    public int q(int t) {

        int left = 0;
        int right = times.length - 1;
        int answer = 0;

        // Find the last voting time <= t
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (times[mid] <= t) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return leaders[answer];
    }

    // Constructor: O(n) time
    // Each query: O(log n) time
    // Space Complexity: O(n)
}
