
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[][] board = new int[n][n];
            int end = n * n;
            int start = 1;
            int x = 0, y = 0, d = 0;
            board[x][y] = start++;

            while (start <= end) {
                x += dirs[d][0];
                y += dirs[d][1];

                if (!(0 <= x && x < n && 0 <= y && y < n) || board[x][y] != 0) {
                    x -= dirs[d][0];
                    y -= dirs[d][1];
                    d = (d + 1 + 4) % 4;
                    continue;
                }
                board[x][y] = start++;
                }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println("#"+tc);
            System.out.print(sb);
        }
    }
}
