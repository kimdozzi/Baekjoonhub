import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됨.
        
        int cnt = 0;
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<progresses.length; i++) {
            int n = progresses[i];
            if (cnt != 0) {
                n += cnt * speeds[i];
                if(n>=100) {
                    ans++;
                    continue;
                } 
                else {
                    list.add(ans);
                    ans = 0;
                }
            }
            
            while (n < 100) {
                n += speeds[i];
                cnt++;
            }    
            ans++;
        }
        if (ans > 0) list.add(ans);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}