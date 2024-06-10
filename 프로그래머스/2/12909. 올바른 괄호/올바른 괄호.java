import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') 
                stk.push(ch);
            if (ch == ')') {
                if (!stk.empty()) {
                    stk.pop();
                }
                else return false;
            }
        }
        
        if (!stk.empty()) return false;
        return true;
    }
}