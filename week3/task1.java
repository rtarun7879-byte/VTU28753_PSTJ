import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine().trim());

        List<List<Integer>> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            String lineStr = scan.nextLine().trim();
            if (!lineStr.isEmpty()) {
                StringTokenizer st = new StringTokenizer(lineStr);
                int count = Integer.parseInt(st.nextToken());
                for (int j = 0; j < count; j++) {
                    row.add(Integer.parseInt(st.nextToken()));
                }
            }
            lines.add(row);
        }

        int q = Integer.parseInt(scan.nextLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(scan.nextLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            List<Integer> row = lines.get(x - 1);
            if (y - 1 >= 0 && y - 1 < row.size()) {
                sb.append(row.get(y - 1)).append("\n");
            } else {
                sb.append("ERROR!").append("\n");
            }
        }

        System.out.print(sb);
        scan.close();
    }
}