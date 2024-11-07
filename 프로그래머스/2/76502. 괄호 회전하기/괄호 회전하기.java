import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        
        // 길이가 홀수면 올바른 괄호가 될 수 없음
        if (n % 2 == 1) return 0;
        
        // 각 회전에 대해 검사
        for (int i = 0; i < n; i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (isValid(rotated)) answer++;
        }
        
        return answer;
    }
    
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char last = stack.pop();
                if (c == ')' && last != '(') return false;
                if (c == '}' && last != '{') return false;
                if (c == ']' && last != '[') return false;
            }
        }
        
        return stack.isEmpty();
    }
}