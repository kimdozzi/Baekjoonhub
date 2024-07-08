
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] stocks = new int[N];
            List<Integer> arr = new ArrayList<>();
            for (int i=0; i<N; i++) {
                stocks[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for (int i=stocks.length-1; i>=0; i--) {
                if (i == stocks.length-1) {
                    arr.add(stocks[i]);
                    continue;
                }
                if (arr.get(arr.size()-1) > stocks[i]) sum += arr.get(arr.size()-1) - stocks[i];
                else if (stocks[i] > arr.get(arr.size()-1)) {
                    arr.add(stocks[i]);
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(sum);
            System.out.println(sb);
        }
    }
}
