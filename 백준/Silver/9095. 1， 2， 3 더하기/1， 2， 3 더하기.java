

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        input();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int ans = rec_func(0, N);
            System.out.println(ans);
        }
    }

    private static int rec_func(int sum, int goal) {
        if (sum > goal) return 0;
        if (sum == goal) return 1;
        int now=0;
        for(int i=1; i<=3; i++) {
            now += rec_func(sum+i, goal);
        }
        return now;
    }
}
