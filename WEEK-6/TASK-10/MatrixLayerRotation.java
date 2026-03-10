import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
    // Write your code here
    int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;

            // top row
            for (int i = left; i <= right; i++)
                elements.add(matrix.get(top).get(i));

            // right column
            for (int i = top + 1; i <= bottom - 1; i++)
                elements.add(matrix.get(i).get(right));

            // bottom row
            for (int i = right; i >= left; i--)
                elements.add(matrix.get(bottom).get(i));

            // left column
            for (int i = bottom - 1; i >= top + 1; i--)
                elements.add(matrix.get(i).get(left));

            int size = elements.size();
            int rot = r % size;

            Collections.rotate(elements, -rot);

            int index = 0;

            // put back values
            for (int i = left; i <= right; i++)
                matrix.get(top).set(i, elements.get(index++));

            for (int i = top + 1; i <= bottom - 1; i++)
                matrix.get(i).set(right, elements.get(index++));

            for (int i = right; i >= left; i--)
                matrix.get(bottom).set(i, elements.get(index++));

            for (int i = bottom - 1; i >= top + 1; i--)
                matrix.get(i).set(left, elements.get(index++));
        }

        for (List<Integer> row : matrix) {
            for (int num : row)
                System.out.print(num + " ");
            System.out.println();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
