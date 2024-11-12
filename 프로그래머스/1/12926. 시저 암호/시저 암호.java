class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                continue;
            }
            
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            int fromPos = c - base;
            int toPos = (fromPos + n  + 26) % 26;
            answer.append((char)(base + toPos));
        }
        return answer.toString();
    }
}