import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length - k;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    // Time Complexity: O(log(n-k) + k)
    // Space Complexity: O(k)
}
