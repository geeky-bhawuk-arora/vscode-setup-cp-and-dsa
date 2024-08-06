import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static int func(int[] arr, int n) {
        if (n == 1)
            return 0;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 1; i <= n; i++) {
            if (i + 1 <= n) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }

            for (int j = i + 1; j <= n; j++) {
                if (arr[j - 1] % arr[i - 1] == 0) {
                    dp[j] = Math.min(dp[j], dp[i] + arr[i - 1]);
                }
            }
        }

        return dp[n];
    }
}

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         int t = scanner.nextInt(); // Number of test cases

//         while (t-- > 0) {
//             int n = scanner.nextInt(); // Size of the array
//             int[] arr = new int[n];
//             for (int i = 0; i < n; i++) {
//                 arr[i] = scanner.nextInt(); // Input array elements
//             }

//             System.out.println(MinCostPath(arr)); // Output the minimum cost
//         }

//         scanner.close();
//     }
// }


