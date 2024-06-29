import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[][] board;
    static int N, D;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            input();

            solve();
        }
    }

    private static void solve() {
        int[][] tempBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            tempBoard[i] = board[i].clone();
        }

        // 시계 방향
        if (D > 0) {
            for (int i = 0; i < D / 45; i++) {
                // 주 대각선 -> 가운데 열
                fromMainCrossToMediumCol(board, tempBoard);
                // 가운데 열 -> 부 대각선
                fromMediumColToSubCross(board, tempBoard);
                // 부 대각선 -> 가운데 행
                fromSubCrossToMediumRow(board, tempBoard);
                // 가운데 행 -> 주 대각선
                fromMediumRowToMainCross(board, tempBoard);

                for (int j = 0; j < N; j++) {
                    board[j] = tempBoard[j].clone();
                }
            }
        }
        // 반시계 방향
        else {
            for (int i = 0; i < (360 + D) / 45; i++) {
                // 주 대각선 -> 가운데 열
                fromMainCrossToMediumCol(board, tempBoard);
                // 가운데 열 -> 부 대각선
                fromMediumColToSubCross(board, tempBoard);
                // 부 대각선 -> 가운데 행
                fromSubCrossToMediumRow(board, tempBoard);
                // 가운데 행 -> 주 대각선
                fromMediumRowToMainCross(board, tempBoard);

                for (int j = 0; j < N; j++) {
                    board[j] = tempBoard[j].clone();
                }
            }
        }

        print();
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 주 대각선 -> 가운데 열
    private static void fromMainCrossToMediumCol(int[][] board, int[][] tempBoard) {
        for (int i = 0; i < N; i++) {
            for (int j = i; j <= i; j++) {
                tempBoard[i][((N + 1) / 2) - 1] = board[i][j];
            }
        }
    }

    // 가운데 열 -> 부 대각선
    private static void fromMediumColToSubCross(int[][] board, int[][] tempBoard) {
        for (int i = 0; i < N; i++) {
            for (int j = i; j <= i; j++) {
                tempBoard[i][N - 1 - i] = board[i][((N + 1) / 2) - 1];
            }
        }

    }

    // 부 대각선 -> 가운데 행
    private static void fromSubCrossToMediumRow(int[][] board, int[][] tempBoard) {
        for (int i = 0; i < N; i++) {
            for (int j = i; j <= i; j++) {
                tempBoard[((N + 1) / 2) - 1][N - i - 1] = board[i][N - i - 1];
            }
        }
    }

    // 가운데 행 -> 주 대각선
    private static void fromMediumRowToMainCross(int[][] board, int[][] tempBoard) {
        for (int i = 0; i < N; i++) {
            for (int j = i; j <= i; j++) {
                tempBoard[N - i - 1][N - j - 1] = board[((N + 1) / 2) - 1][N - i - 1];
            }
        }
    }


    private static void input() throws IOException {
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
