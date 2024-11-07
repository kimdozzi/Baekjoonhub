import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			int[][] board = new int[n][3];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			board[0][2] += board[0][1];
			board[1][0] += board[0][1];
			board[1][1] += Math.min(board[0][1], Math.min(board[0][2], board[1][0]));
			board[1][2] += Math.min(board[1][1], Math.min(board[0][1], board[0][2]));

			for (int i = 2; i < n; i++) {
				board[i][0] += Math.min(board[i - 1][0], board[i - 1][1]);

				board[i][1] += Math.min(board[i][0],
					Math.min(board[i - 1][0], Math.min(board[i - 1][1], board[i - 1][2])));
				board[i][2] += Math.min(board[i][1], Math.min(board[i - 1][1], board[i - 1][2]));
			}

			System.out.println((tc++) + ". " + board[n - 1][1]);
		}
	}
}
