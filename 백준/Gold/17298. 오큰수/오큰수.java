import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stk = new Stack<>();
		int[] res = new int[n];
		Arrays.fill(res, -1);
		
		for (int i = 0; i < n; i++) {
			while (!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
				res[stk.pop()] = arr[i];
			}
			stk.push(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			sb.append(res[i]).append(" ");
		}
		System.out.println(sb);
	}
}
