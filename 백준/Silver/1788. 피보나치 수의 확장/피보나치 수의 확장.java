import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int MOD = 1_000_000_000;

		int[] dp = new int[1000001];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= 1000000; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2])%MOD;
		}

		if (n < 0 && n % 2 == 0) {
			System.out.println(-1);
			System.out.println(dp[-n]);
		} else if (n == 0) {
			System.out.println(0);
			System.out.println(0);
		} else {
			System.out.println(1);
			System.out.println(dp[Math.abs(n)]);
		}
	}
}