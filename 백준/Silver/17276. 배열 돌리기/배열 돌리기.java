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
        boardClone(tempBoard, board);

        if (D < 0)
            D += 360;

        for (int i = 0; i < D / 45; i++) {

            rotate(board, tempBoard);

            boardClone(board, tempBoard);
        }
        print();
    }

    private static void boardClone(int[][] board, int[][] tempBoard) {
        for (int i = 0; i < N; i++) {
            board[i] = tempBoard[i].clone();
        }
    }

    private static void rotate(int[][] board, int[][] tempBoard) {
        for (int i=0; i<N; i++) {
            tempBoard[i][N/2] = board[i][i];
            tempBoard[i][N-i-1] = board[i][N/2];
            tempBoard[N/2][N-i-1] = board[i][N-i-1];
            tempBoard[N-i-1][N-i-1] = board[N/2][N-i-1];
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
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