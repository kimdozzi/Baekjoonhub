import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 메인 클래스 정의
public class Main {
    // 격자의 크기 (n: 행, m: 열)
    static int n, m;
    // 직사각형의 크기 (h: 높이, w: 너비)
    static int h, w;
    // 시작점 좌표 (sx, sy)와 도착점 좌표 (ex, ey)
    static int sx, sy, ex, ey;
    // 상, 우, 하, 좌 방향 이동을 위한 dx, dy 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    // 방문 여부를 체크하는 2차원 배열
    static boolean[][] visit;
    // 2차원 누적 합을 저장하는 배열
    static int[][] preSum;
    // 원본 격자 정보를 저장하는 배열
    static int[][] map;

    // 좌표를 표현하는 내부 클래스
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // (x, y)를 좌상단으로 하는 h x w 크기 직사각형 내의 벽 개수를 반환하는 함수
    static int ares(int x, int y) {
        // 누적 합을 이용해 O(1) 시간에 영역 합 계산
        return preSum[x + h - 1][y + w - 1] - preSum[x - 1][y + w - 1] - preSum[x + h - 1][y - 1] + preSum[x - 1][y - 1];
    }

    // BFS를 수행하여 최단 거리를 찾는 함수
    static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        visit[sx][sy] = true;
        q.add(new Pair(sx, sy));
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            // 현재 깊이의 모든 노드를 처리
            for (int k = 0; k < size; k++) {
                Pair p = q.poll();
                // 도착점에 도달했다면 현재까지의 거리 반환
                if (p.x == ex && p.y == ey) return distance;

                // 4방향으로의 이동을 시도
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    // 격자를 벗어나거나 이미 방문한 칸이면 스킵
                    if (nx < 1 || nx + h - 1 > n || ny < 1 || ny + w - 1 > m || visit[nx][ny]) continue;
                    // 이동하려는 영역에 벽이 있으면 스킵
                    if (ares(nx, ny) > 0) continue;
                    visit[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
            // 깊이(거리) 증가
            distance += 1;
        }
        // 도착점에 도달할 수 없는 경우
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 격자의 크기 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1][m + 1];
        map = new int[n + 1][m + 1];

        // 격자 정보 입력
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 직사각형의 크기와 시작점, 도착점 입력
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        // 2차원 누적 합 계산
        preSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + map[i][j];
            }
        }

        // BFS 수행 및 결과 출력
        int answer = bfs();
        System.out.println(answer);
    }
}