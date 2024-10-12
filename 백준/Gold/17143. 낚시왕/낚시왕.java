import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int R, C, M;
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static Node map[][];
	static int ans = 0;
	static ArrayList<Node> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] t = br.readLine().split(" ");
		R = Integer.parseInt(t[0]);
		C = Integer.parseInt(t[1]);
		M = Integer.parseInt(t[2]);
		int fisher = 0;
		map = new Node[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			String[] tt = br.readLine().split(" ");
			int r = Integer.parseInt(tt[0]);
			int c = Integer.parseInt(tt[1]);
			int s = Integer.parseInt(tt[2]);
			int d = Integer.parseInt(tt[3]) - 1;
			if (d == 1) {
				d = 2;
			} else if (d == 2) {
				d = 1;
			}
			int z = Integer.parseInt(tt[4]);
			Node node = new Node(r, c, s, d, z);
			map[r][c] = node;
			list.add(node);
		}
		if (M == 0) {
			System.out.println(0);
			return;
		}
		while (fisher < C) {
			fisher++;
			hunt_shark(fisher);
			move_shark();
			eat_shark();
		}
		System.out.println(ans);
	}

	public static void eat_shark() {
		for (int i = list.size() - 1; i >= 0; i--) {
			Node a = list.get(i);

			if (map[a.x][a.y] == null) {
				map[a.x][a.y] = a;
			} else {      // 맵에 이미 고기가 있을때
				if (map[a.x][a.y].z > a.z) {
					list.remove(a);
				} else {
					list.remove(map[a.x][a.y]);
					map[a.x][a.y] = a;
				}
			}
		}
	}

	public static void move_shark() {
		for (int i = 0; i < list.size(); i++) {
			Node a = list.get(i);
			map[a.x][a.y] = null;
			int x = a.x;
			int y = a.y;
			int s = a.s;
			int d = a.d;
			int z = a.z;

			if (d == 0 || d == 2) {      // 위아래만 고려
				s = s % ((R - 1) * 2);
			} else {  // 좌우만 고려
				s = s % ((C - 1) * 2);
			}

			for (int j = 0; j < s; j++) {
				if (isRange(x + dx[d], y + dy[d])) {
					x += dx[d];
					y += dy[d];
				} else {
					d = (d + 2) % 4;
					x += dx[d];
					y += dy[d];
				}
			}
			list.set(i, new Node(x, y, s, d, z));
		}
	}

	public static void hunt_shark(int fisher_pos) {
		for (int i = 1; i <= R; i++) {
			if (map[i][fisher_pos] != null) {
				ans += map[i][fisher_pos].z;
				list.remove(map[i][fisher_pos]);
				map[i][fisher_pos] = null;
				break;
			}
		}
	}

	public static boolean isRange(int x, int y) {
		if (x >= 1 && y >= 1 && x <= R && y <= C) {
			return true;
		}
		return false;
	}
}

class Node {
	int x, y, s, d, z;

	Node(int x, int y, int s, int d, int z) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}
