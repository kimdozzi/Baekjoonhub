import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int ans = 0;

        if ((A + B) <= C * 2) {
            ans += (A * X) + (B * Y);
        } else {
            if (X > Y) {
                ans += Y * (C * 2);
                ans += Math.min((X - Y) * A, (X - Y) * (C * 2));
            } else {
                ans += X * (C * 2);
                ans += Math.min((Y - X) * B, (Y - X) * (C * 2));
            }
        }
        System.out.print(ans);
    }
}
