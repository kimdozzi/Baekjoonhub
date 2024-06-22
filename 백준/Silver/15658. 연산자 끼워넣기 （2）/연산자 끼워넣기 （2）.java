
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr, oper = new int[4];
    static int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        // init
        input();

        //solve
        solve(0, new StringBuilder());

        System.out.print(mx + "\n" + mn);
    }

    private static void solve(int depth, StringBuilder sb){
        if(depth == n-1) {
            int res = find(sb);
            mx = Math.max(mx, res);
            mn = Math.min(mn, res);
            return;
        }

        for(int i=0; i<4; i++) {
            if(oper[i] > 0) {
                oper[i] -= 1;
                sb.append(i);
                solve(depth + 1, sb);
                oper[i] += 1;
                sb.deleteCharAt(depth);
            }
        }
    }

    private static int find(StringBuilder sb) {
        int sum = arr[0];
        for(int i=1; i<arr.length; i++) {
            int num = Integer.parseInt(sb.substring(i-1,i));
            switch (num) {
                case 0:
                    sum += arr[i];
                    break;
                case 1:
                    sum -= arr[i];
                    break;
                case 2:
                    sum *= arr[i];
                    break;
                case 3:
                    sum /= arr[i];
                    break;
                default:
                    break;
            }
        }
        return sum;
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
            oper[i] = Integer.parseInt(st.nextToken());
    }
}
