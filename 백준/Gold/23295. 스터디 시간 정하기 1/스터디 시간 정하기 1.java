import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] times;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		times = new int[100001];

		for (int i = 0; i < N; i++) {
			int K = Integer.parseInt(br.readLine());
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				times[from] += 1;
				times[to] += -1;
			}
		}

		for (int i = 1; i < 100001; i++) {
			times[i] += times[i - 1];
		}

		int mt = Integer.MIN_VALUE;

		int sum = 0;
		int idx = 0;
		for (int i = 0; i < 100001 - K; i++) {
			for (int j = i; j < i + K; j++) {
				sum += times[j];
			}
			if (mt < sum) {
				idx = i;
				mt = sum;
			}
			sum = 0;
		}
		System.out.println(idx + " " + (idx + K));

	}
}
