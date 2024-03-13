
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            arr.add(i);
        }

        int[] ans = new int[n];
        int currentIdx = 0;
        for (int i=0; i<n; i++) {
            currentIdx = (currentIdx + m - 1) % arr.size();
            ans[i] = arr.remove(currentIdx);
        }

        System.out.print("<");
        for (int i=0; i<n-1; i++) {
            System.out.print(ans[i] + ", ");
        }
        System.out.print(ans[n-1] + ">");

    }
}
