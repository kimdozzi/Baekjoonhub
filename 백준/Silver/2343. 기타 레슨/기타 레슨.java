import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
        
        int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
		}
		
		int lo = max - 1, hi = 1000001;
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;

			int cnt = 0;
			int currentSum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (currentSum + arr[i] > mid) {
					cnt++;
					currentSum = 0;
				}
				currentSum += arr[i];
			}
            
            if (currentSum > 0 && currentSum <= mid) cnt++;

			if (cnt <= m) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		System.out.println(hi);
	}
}