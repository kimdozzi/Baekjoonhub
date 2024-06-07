import java.util.*;
class Solution {
    public long solution(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for (String val : list) sb.append(val);
        
        
        return Long.parseLong(sb.reverse().toString());
    }
}