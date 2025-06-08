package challenges.betweentwosets;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcmVal = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            lcmVal = lcm(lcmVal, a.get(i));
        }

        int gcdVal = b.get(0);
        for (int i = 1; i < b.size(); i++) {
            gcdVal = gcd(gcdVal, b.get(i));
        }

        int count = 0;
        for (int x = lcmVal; x <= gcdVal; x += lcmVal) {
            if (gcdVal % x == 0) {
                count++;
            }
        }
        return count;
    }

    /*private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }*/
    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = br.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(br.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(br.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);
        bw.write(String.valueOf(total));
        bw.newLine();

        br.close();
        bw.close();
    }
}
