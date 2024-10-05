import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pair implements Comparable<Pair> {
		int x;
		int y;
		int val;

		public Pair(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(Pair o1) {
			return this.val - o1.val;
		}
	}

	static int N, M;
	static int[][] board;
	static int answer = Integer.MAX_VALUE;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int[] picked;
	static List<int[]> virus;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		picked = new int[M];
		virus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2)
					virus.add(new int[] {i, j});
			}
		}

		boolean isAvailable = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					isAvailable = true;
				}
			}
		}

		if (isAvailable) {
			rec_func(0, 0);
			System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		} else {
			System.out.println(0);
		}
	}

	private static void rec_func(int cnt, int start) {
		if (cnt == M) {
			int sum = spread();
			if (sum == -1)
				return;

			answer = Math.min(answer, sum);
			return;
		}

		for (int i = start; i < virus.size(); i++) {
			picked[cnt] = i;
			rec_func(cnt + 1, i + 1);
		}
	}

	private static int spread() {
		int[][] tempBoard = new int[N][N];

		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < picked.length; i++) {
			int[] xy = virus.get(picked[i]);
			int x = xy[0];
			int y = xy[1];
			q.add(new Pair(x, y, 0));
		}

		boolean[][] visit = new boolean[N][N];

		while (!q.isEmpty()) {
			Pair pair = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = pair.x + dirs[i][0];
				int ny = pair.y + dirs[i][1];

				if (!inRange(nx, ny))
					continue;
				if (visit[nx][ny])
					continue;
				if (board[nx][ny] == 1)
					continue;

				if (board[nx][ny] == 0) {
					tempBoard[nx][ny] = pair.val + 1;
				}
				visit[nx][ny] = true;
				q.add(new Pair(nx, ny, pair.val + 1));
			}
		}
		int cnt = -1;
		for (int i = 0; i < tempBoard.length; i++) {
			for (int j = 0; j < tempBoard[i].length; j++) {
				if (board[i][j] == 0 && !visit[i][j])
					return -1;
				cnt = Math.max(cnt, tempBoard[i][j]);
			}
		}

		// System.out.println(cnt);
		return cnt;
	}

	private static boolean inRange(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}
}