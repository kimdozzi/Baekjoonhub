import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 101;
        int idx = 0;
        
        Arrays.sort(array);
        for(int i=0; i<array.length; i++) {
            if (Math.abs(n-array[i]) < answer) {
                answer = n-array[i];
                idx = i;
            }
        }
        return array[idx];
    }
}