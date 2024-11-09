import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int[] down = new int[N/2];  // 석순
        int[] up = new int[N/2];    // 종유석
        
        for(int i = 0; i < N/2; i++) {
            down[i] = Integer.parseInt(br.readLine());      // 석순
            up[i] = Integer.parseInt(br.readLine());        // 종유석
        }
        
        Arrays.sort(down);
        Arrays.sort(up);
        
        int minObstacle = N;    // 최소 장애물 수
        int count = 0;          // 구간의 수
        
        for(int h = 1; h <= H; h++) {
            int downCount = down.length - binarySearch(down, h);
            int upCount = up.length - binarySearch(up, H-h+1);
            
            int total = downCount + upCount;
            
            if(total < minObstacle) {
                minObstacle = total;
                count = 1;
            } else if(total == minObstacle) {
                count++;
            }
        }
        
        System.out.println(minObstacle + " " + count);
    }
    
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while(left < right) {
            int mid = (left + right) / 2;
            
            if(arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}