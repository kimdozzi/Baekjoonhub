import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static boolean[][] vis;
	static int[][] board;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		vis = new boolean[n][m];
		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 1 && !vis[i][j]) {
					count++;
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}
		System.out.println(count + "\n" + ans);
	}

	private static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		vis[x][y] = true;

		int cnt = 1;
		while (!q.isEmpty()) {
			int[] current = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = current[0] + dirs[d][0];
				int ny = current[1] + dirs[d][1];

				if (!inRange(nx, ny))
					continue;
				if (vis[nx][ny])
					continue;
				if (board[nx][ny] != 1)
					continue;

				vis[nx][ny] = true;
				q.add(new int[] {nx, ny});
				cnt++;
			}
		}
		return cnt;
	}

	private static boolean inRange(int nx, int ny) {
		return 0 <= nx && nx < n && 0 <= ny && ny < m;
	}
}

