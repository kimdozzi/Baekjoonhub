import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string); 
        int n = st.countTokens();
        String[] answer = new String[n];
        int i = 0;
        while (st.hasMoreTokens()) {
            answer[i++] = st.nextToken();
        }
        return answer;
    }
}