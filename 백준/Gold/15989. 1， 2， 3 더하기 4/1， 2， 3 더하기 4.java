import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];
        for(int i = 0; i < T; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[4][10001];
        dp[0][0] = 1;

        for(int i=1; i<4; i++) {
            for(int j=0; j<=10000; j++) {
                if (i > j) dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i][j-i] + dp[i-1][j];
            }
        }

        for(int i=0; i<T; i++) {
            System.out.println(dp[3][arr[i]]);
        }
    }
}