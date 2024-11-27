import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

		Stack<int[]> stk = new Stack<>();
		int[] res = new int[n];
		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stk.isEmpty() && stk.peek()[1] < arr[i]) {
				int[] data = stk.pop();
				int idx = data[0];
				res[idx] = i + 1;
			}
			stk.add(new int[] {i, arr[i]});
		}

		for (int ans : res) {
			System.out.print(ans + " ");
		}
	}
}
