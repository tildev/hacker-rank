package challenges.magicsquareforming;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        int[][][] magicSquares = {
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}
        };
        int result = Integer.MAX_VALUE;
        for (int[][] magicSquare : magicSquares) {
            int cost = 0;
            for (int j = 0; j < s.size(); j++) {
                for (int k = 0; k < s.get(j).size(); k++) {
                    if (magicSquare[j][k] != s.get(j).get(k)) {
                        cost += Math.abs(magicSquare[j][k] - s.get(j).get(k));
                    }
                }
            }
            result = Math.min(result, cost);
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
