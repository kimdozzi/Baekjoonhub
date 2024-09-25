class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String s = "";
        for(int i=0; i<my_string.length(); i++) {
            int temp = my_string.charAt(i) -'0';
            if(0 <= temp && temp <= 9) {
                s += String.valueOf(my_string.charAt(i));
            } else {
                if (s.length() > 0) {
                    answer += Integer.parseInt(s);
                    s = "";
                }
            }
        }
        if(s.length() > 0) {
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}