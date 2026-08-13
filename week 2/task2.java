import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();

        System.out.println(maxUniqueSubarray(arr, n, m));
    }

    static int maxUniqueSubarray(int[] arr, int n, int m) {
        Deque<Integer> deque = new LinkedList<>();
        Map<Integer, Integer> count = new HashMap<>();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            // Add current element to the window
            deque.addLast(arr[i]);
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);

            // If window exceeds size m, remove from the front
            if (deque.size() > m) {
                int removed = deque.pollFirst();
                int c = count.get(removed);
                if (c == 1) {
                    count.remove(removed);
                } else {
                    count.put(removed, c - 1);
                }
            }

            // Once window reaches size m, check unique count
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, count.size());
            }
        }

        return maxUnique;
    }
}