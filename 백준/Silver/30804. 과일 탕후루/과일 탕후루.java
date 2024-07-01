import java.io.*;

public class Main {
    private static BufferedReader br;
    private static int N;
    private static int[] arr;
    private static int[] nums = new int[10];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } 

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(twoPointer(0, 0, 0, 0, 0));
        return sb.toString();
    } 

    private static int twoPointer(int left, int right, int cnt, int kind, int max) {
        if (right >= N) {
            return max;
        }

        if (nums[arr[right]] == 0) {
            kind++;
        }

        cnt++;
        nums[arr[right]]++;

        if (kind > 2) {
            if (--nums[arr[left]] == 0) {
                kind--;
            }
            cnt--;
            left++;
        }

        max = Math.max(max, cnt);

        return twoPointer(left, right + 1, cnt, kind, max);
    } 

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i << 1) - '0';
        }
    } 
} 