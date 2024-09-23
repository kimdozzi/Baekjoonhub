class Solution {
    public String solution(int age) {
        String answer = "";
        while(age > 0) {
            answer = String.valueOf((char) (age%10 + 'a')) + answer;
            age /= 10;
        }
        
        return answer;
    }
}