import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        System.out.println(sb);
    }
    private static void rec_func(int depth) {
        if(depth == M+1) {
            for(int i = 1; i <= M; i++) sb.append(selected[i]).append(" ");
            sb.append("\n");
        } else {
            for(int i = selected[depth-1] + 1; i <= N; i++) {
                selected[depth] = i;
                rec_func(depth+1);
                selected[depth] = 0;
            }
        }
    }

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        selected = new int[M+1];
    }
}
