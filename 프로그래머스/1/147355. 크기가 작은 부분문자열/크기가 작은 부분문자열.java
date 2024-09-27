class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long temp = Long.parseLong(p);
        for(int i=0; i<t.length()-p.length()+1; i++) {
            if (temp>=Long.parseLong(t.substring(i,i+p.length()))) {
                answer++;
            }
        }
        return answer;
    }
}