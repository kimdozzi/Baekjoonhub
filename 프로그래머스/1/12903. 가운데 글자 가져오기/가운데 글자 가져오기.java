class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int length = s.length();
        if (length % 2 == 0) {
            int r = (int) (length / 2);
            int l = (int) (length / 2) - 1;
            sb.append(s.substring(l,r+1));
        } else {
            int m = (int) (length / 2);
            sb.append(s.substring(m,m+1));
        }
        
        return sb.toString();
    }
}