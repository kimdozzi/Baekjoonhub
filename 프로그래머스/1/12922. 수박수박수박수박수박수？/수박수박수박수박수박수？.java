class Solution {
    public String solution(int n) {
        String[] strArr = new String[]{"수", "박"};
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            sb.append(strArr[(i-1)%2]);
        }
        
        return sb.toString();
    }
}