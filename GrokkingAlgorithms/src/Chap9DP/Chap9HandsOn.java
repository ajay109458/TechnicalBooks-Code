package Chap9DP;

import java.util.Arrays;

public class Chap9HandsOn {

    public static void main(String[] args) {
        validateQuestion1();
        validateQuestion2();
        validateQuestion3();
        validateQuestion4();
        validateQuestion5();
        validateQuestion6();
        validateQuestion7();
        validateQuestion8();
        validateQuestion9();
        validateQuestion10();
    }

    public static void validateQuestion1() {
        int n = 10;

        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(n + "th term in fibonacci is : " + dp[n - 1]);
    }

    public static void validateQuestion2() {
        int sum = 11;
        int[] coins = {1, 2, 5};
        int[] dp = new int[sum + 1];


        for (int s = 1; s <= sum; s++) {
            dp[s] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (s >= coin) {
                    dp[s] = Math.min(dp[s-coin] + 1, dp[s]);
                }
            }
        }

        System.out.println("Minimum numbers of the coin required is: " + dp[sum]);
    }

    public static void validateQuestion3() {
        String s1 = "AGGTAB";
        String s2  = "GXTXAYB";

        int m = s1.length();
        int n = s2.length();

        // DP table to store lengths of LCS
        int[][] dp = new int[m + 1][n + 1];

        // Build the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct the LCS from the DP table
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // The LCS is built in reverse order
        String result =  lcs.reverse().toString();
        System.out.println(result);
    }

    // 0-1 Knapsack dynamic programmming
    public static void validateQuestion4() {
        int[] weights = {6, 3, 4};
        int[] values = {30, 14, 16};
        int capacity = 10;
        int n = weights.length;

        // DP table to store the maximum value for each weight capacity
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int result =  dp[n][capacity];
        System.out.println(result);
    }

    public static void validateQuestion5() {
        String s1 = "sitting";
        String s2 = "kitten";

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        System.out.println(dp[s1.length()][s2.length()]);
    }

    public static void validateQuestion6() {
        int[] prices = {1, 5, 8, 9, 10};
        int length = 8;

        // DP table to store the maximum profit for each rod length
        int[] dp = new int[length + 1];

        // Build the DP table
        for (int i = 1; i <= length; i++) {
            int maxProfit = Integer.MIN_VALUE;
            for (int j = 1; j <= i && j <= prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j - 1] + dp[i - j]);
            }
            dp[i] = maxProfit;
        }

        System.out.println(dp[length]);
    }

    public static void validateQuestion7() {
        int[] dims = {10, 20, 30, 40};

        // Solve the matrix chain multiplication problem
        int minMultiplications = matrixMultiplications(dims);

        // Output the result
        System.out.println("Minimum number of scalar multiplications: " + minMultiplications);
    }

    private static int matrixMultiplications(int[] dims) {
        int n = dims.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) { // len is the chain length
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dims[i - 1] * dims[k] * dims[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n-1];
    }

    public static void validateQuestion8() {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target+1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= target; s++) {
                if (s >= nums[i-1]) {
                    dp[i][s] = dp[i-1][s-nums[i-1]] || dp[i-1][s];
                }
            }
        }

        System.out.println(dp[n][target]);
    }




    public static void validateQuestion9() {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80};

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    public static void validateQuestion10() {

    }

}
