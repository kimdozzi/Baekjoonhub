import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int n = number.length;
        
        for(int k=0; k<n; k++) {
            for(int i=k+1; i<n; i++) {
                for(int j=i+1; j<n; j++) {
                    if(number[i]+number[j]+number[k]==0) answer++;
                }
            }
        }
        return answer;
    }
}