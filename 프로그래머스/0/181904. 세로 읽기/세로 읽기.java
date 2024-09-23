class Solution {
    public String solution(String my_string, int m, int c) {
        String[] answer = new String[my_string.length()/m];
        int n = 0;
        int idx = 0;
        while(n < my_string.length()) {
            answer[idx++] = my_string.substring(n, n+m);
            n += m;
        }
        String res = "";
        for(int i=0; i<answer.length; i++) {
            res += answer[i].charAt(c-1) + "";
        }
        return res;
    }
}