import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int r, g; // r은 그룹의 크기, g는 그룹의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringJoiner sj = new StringJoiner("\n");

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        r = (int) Math.floor(Math.sqrt(N));
        g = N / r;
        if (N % r != 0) {
            g++;
        }
        int[] d = new int[g];

        for (int i = 0; i < N; i++) {
            if (i % r == 0) {
                d[i/r] = arr[i];
            } else {
                if (d[i/r] > arr[i]) {
                    d[i/r] = arr[i];
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (command == 1) // 구간 최솟값 구하기
            {
                update(arr, d, r, x-1, y);
            }
            else {
                int res = query(arr, d, r, x - 1, y - 1);
                sj.add(String.valueOf(res));
            }
        }
        System.out.println(sj);
    }

    private static void update(int[] a, int[] d, int r, int index, int v) {
        a[index] = v;
        int group = index/r;
        int start = group * r;
        int end = start + r;
        if (end > a.length) end = a.length;
        d[group] = a[start];
        for (int i=start; i<end; i++) {
            if (d[group] > a[i])
                d[group] = a[i];
        }
    }

    private static int query(int[] a, int[] d, int r, int start, int end) {
        int ans = a[start]; // 최솟값을 구하기 위해 탐색을 시작할 처음 값
        
        if (start/r == end/r) { // 만약 같은 그룹에 속한다면
            for (int i=start; i<=end; i++) {
                if (ans > a[i])
                    ans = a[i];
            }
            return ans;
        }

        // 시작 l부터 l이 속한 그룹 끝까지 탐색.
        while (true) {
            if (ans > a[start]) {
                ans = a[start];
            }
            start += 1;

            if(start % r == 0) break;
        }

        // 끝 r부터 r이 속한 그룹의 시작까지 탐색.
        while (true) {
            if (ans > a[end]) {
                ans = a[end];
            }
            end -= 1;

            if (end % r == r-1) break;
        }

        int startGroup = start/r;
        int endGroup = end/r;
        for(int i=startGroup; i<=endGroup; i++) {
            if (ans > d[i])
                ans = d[i];
        }
        return ans;
    }
}
