class Solution {
    public String solution(String phone_number) {
        int length = phone_number.length();
        String str = phone_number.substring(length-4);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length-4; i++) {
            sb.append("*");
        }
        sb.append(str);
        return sb.toString();
    }
}