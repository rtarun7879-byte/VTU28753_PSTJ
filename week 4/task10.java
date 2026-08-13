import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();
        int n = matrix.get(0).size();

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            // Top row: left -> right
            for (int j = layer; j < n - layer; j++) {
                elements.add(matrix.get(layer).get(j));
            }

            // Right column: top -> bottom
            for (int i = layer + 1; i < m - layer; i++) {
                elements.add(matrix.get(i).get(n - layer - 1));
            }

            // Bottom row: right -> left
            for (int j = n - layer - 2; j >= layer; j--) {
                elements.add(matrix.get(m - layer - 1).get(j));
            }

            // Left column: bottom -> top
            for (int i = m - layer - 2; i > layer; i--) {
                elements.add(matrix.get(i).get(layer));
            }

            // Effective rotations
            int rotate = r % elements.size();

            // Put rotated elements back
            int index = rotate;

            // Top row
            for (int j = layer; j < n - layer; j++) {
                matrix.get(layer).set(j, elements.get(index));
                index = (index + 1) % elements.size();
            }

            // Right column
            for (int i = layer + 1; i < m - layer; i++) {
                matrix.get(i).set(n - layer - 1, elements.get(index));
                index = (index + 1) % elements.size();
            }

            // Bottom row
            for (int j = n - layer - 2; j >= layer; j--) {
                matrix.get(m - layer - 1).set(j, elements.get(index));
                index = (index + 1) % elements.size();
            }

            // Left column
            for (int i = m - layer - 2; i > layer; i--) {
                matrix.get(i).set(layer, elements.get(index));
                index = (index + 1) % elements.size();
            }
        }

        // Print matrix
        for (List<Integer> row : matrix) {
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j));

                if (j < row.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }

            matrix.add(row);
        }

        matrixRotation(matrix, r);
    }
}