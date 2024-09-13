import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[10001];
        
        int idx = 0;
        for(int i=0; i<arr.length; i++) {
            int num = arr[i];
            while (num-- > 0) {
                answer[idx++] = arr[i];
            }
        }
        return Arrays.copyOfRange(answer,0,idx);
    }
}