import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N;
    static long[][] dp = new long[100001][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 2;


        for (int i = 4; i <= 100000; i++) {
            dp[i][0] = (dp[i-1][1] + dp[i-2][1] + dp[i-3][1]) % 1_000_000_009;
            dp[i][1] = (dp[i-1][0] + dp[i-2][0] + dp[i-3][0]) % 1_000_000_009;
        }

        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }
}