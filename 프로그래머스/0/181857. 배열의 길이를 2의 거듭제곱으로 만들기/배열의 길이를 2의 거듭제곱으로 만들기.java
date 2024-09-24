import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int n = 1;
        while(arr.length > n) {
            n*=2;
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 0);
        
        for(int i=0; i<arr.length; i++) {
            ans[i] = arr[i];
        }
        
        return ans;
    }
    
}