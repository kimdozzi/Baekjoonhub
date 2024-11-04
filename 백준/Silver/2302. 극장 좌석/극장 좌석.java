import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(br.readLine());
			arr[x] = 0;
		}
		int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= 40; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int cnt = 0;
		int ans = 1;
		for (int i = 1; i <= n; i++) {
			if (arr[i] == 0) {
				ans *= dp[cnt];
				cnt = 0;
			} else {
				cnt++;
			}
		}
		if (cnt > 0)
			ans *= dp[cnt];
		System.out.println(ans);

	}
}