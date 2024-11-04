class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                continue;
            }
            
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            answer.append((char) (base + (c - base + n) % 26));
        }
        return answer.toString();
    }
}