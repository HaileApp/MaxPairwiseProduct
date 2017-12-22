import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static Long getMaxPairwiseProduct(Long[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    static Long getMaxPairwiseProductFast(Long[] numbers) {
      int n = numbers.length;

      int max_index1 = -1;
      for (int i = 0; i < n; i++) {
        if ((max_index1 == -1) || (numbers[i] > numbers[max_index1])) {
          max_index1 = i;
        }
      }

      int max_index2 = -1;
      for (int j = 0; j < n; j++) {
        if ((numbers[j] != numbers[max_index1]) && ((max_index2 == -1) || (numbers[j] > numbers[max_index2]))) {
          max_index2 = j;
        }
      }

      return numbers[max_index1] * numbers[max_index2];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        // create a Random java object
        Random random = new Random();

        // int n = scanner.nextInt();
        // Long[] numbers = new Long[n];
        // for (int i = 0; i < n; i++) {
        //     numbers[i] = scanner.nextLong();
        // }
        // //Long result1 = getMaxPairwiseProduct(numbers);
        // Long result2 = getMaxPairwiseProductFast(numbers);
        // System.out.println(result2);
        while (true) {
          int n = (int) (Math.random() * 10) + 2;
          System.out.println("------");
          System.out.println(n);
          Long[] numbers = new Long[n];

          for (int i = 0; i < n; i++) {
            //numbers[i] = (Long) (Math.random() % 100000);
            //numbers[i] = (Long)(Math.floor(Math.random() * 1000));
            numbers[i] = (long) (1 + (random.nextInt(100)));
          }

          for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
          }

          long res1 = getMaxPairwiseProduct(numbers);
          long res2 = getMaxPairwiseProductFast(numbers);
          if (res1 != res2) {
            System.out.println("Wrong answer: " + res1 + " " + res2);
            break;
          } else {
            System.out.println("OK");
          }

        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }
    }

}
