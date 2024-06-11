class Solution {
    public String solution(String[] seoul) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=0; i<seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                idx = i;
                break;
            }
        }
        sb.append("김서방은 ").append(String.valueOf(idx)).append("에 있다");
        return sb.toString();
    }
}