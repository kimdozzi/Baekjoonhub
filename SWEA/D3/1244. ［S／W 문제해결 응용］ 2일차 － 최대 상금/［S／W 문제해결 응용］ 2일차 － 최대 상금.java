import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[] arr;
    static int ans, move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] strArr = br.readLine().split(" ");
            move = Integer.parseInt(strArr[1]);

            arr = new int[strArr[0].length()];
            String[] temp = strArr[0].split("");

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(temp[i]);
            }

            if (arr.length < move) {
                move = arr.length;
            }

            ans = 0;
            backTracking(0, 0);

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            System.out.print(sb);
        }
    }

    private static void backTracking(int idx, int cnt) {
        if (move == cnt) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            ans = Math.max(Integer.parseInt(sb.toString()), ans);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                backTracking(idx, cnt+1);

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
