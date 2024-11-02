import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt = s.length();
        Deque<Character> q = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++) {
            q.addLast(s.charAt(i));
        }
        for(int i=0; i<cnt; i++) {
            q.addLast(q.pollFirst());
            List<Character> list = new ArrayList<>();
            Iterator<Character> iter = q.iterator();
            while(iter.hasNext()) {
                char str = iter.next();
                if (list.size() == 0) {
                    list.add(str);
                    continue;
                }
                if ( str == ')' && list.get(list.size()-1) == '(') {
                    list.remove(list.size()-1);
                    continue;
                } else if (str == '}' && list.get(list.size()-1).equals('{')) {
                    list.remove(list.size()-1);
                    continue;
                }
                else if (str == ']' && list.get(list.size()-1).equals('[')) {
                    list.remove(list.size()-1);
                    continue;
                }
                list.add(str);
            }
            if (list.size() == 0) answer++;
        }
        
        return answer;
    }
}