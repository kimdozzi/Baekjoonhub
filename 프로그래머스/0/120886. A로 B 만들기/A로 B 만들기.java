import java.util.*;

class Solution {
    public int solution(String before, String after) {
        if (before.length() == 0 || after.length() == 0) return 0;
        
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<after.length(); i++) {
            map.put(after.charAt(i), map.getOrDefault(after.charAt(i), 0)+1);
        }
        
        for(int i=0; i<before.length(); i++) {
            map.put(before.charAt(i), map.getOrDefault(before.charAt(i), 1000)-1);
        }
        
        Iterator<Character> keys = map.keySet().iterator();
        
        while(keys.hasNext()) {
            char s = keys.next();
            System.out.print(s + " " + map.get(s));
            if(map.get(s) != 0) return 0;
        }
        return 1;
    }
}