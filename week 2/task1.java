import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine().trim());

        Set<String> uniquePairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] pair = scan.nextLine().trim().split(" ");
            String combined = pair[0] + "#" + pair[1];
            uniquePairs.add(combined);
            System.out.println(uniquePairs.size());
        }

        scan.close();
    }
}