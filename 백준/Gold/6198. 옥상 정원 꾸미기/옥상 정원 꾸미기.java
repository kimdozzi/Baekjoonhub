import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int mx = 0;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			mx = Math.max(mx, arr[i]);
		}
		arr[n] = mx;
		
		Stack<Integer> stk = new Stack<>();
		int[] res = new int[n];
		
		for(int i=0; i<=n; i++) {
			while(!stk.isEmpty() && arr[stk.peek()] <= arr[i]) {
				int idx = stk.pop();
				res[idx] = i - idx - 1;
			}
			if (i == n-1) {
				
			}
			stk.add(i);
		}
		
		long ans = 0;
		for(int i=0; i<n; i++) {
			ans += res[i];
		}
		System.out.println(ans);
	}
}
