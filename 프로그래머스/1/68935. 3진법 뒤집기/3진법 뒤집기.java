import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> arr = new ArrayList<>();
        while (true) {
            if(n==0) break;
            
            // 나머지 구하기
            int x = n % 3;
            // 몫 구하기 
            n /= 3;
            
            arr.add(x);
        }
        
        int j = 0;
        for(int i=arr.size()-1; i>=0; i--, j++) {
            answer += arr.get(i) * Math.pow(3, j);
        }
        return answer;
    }
}