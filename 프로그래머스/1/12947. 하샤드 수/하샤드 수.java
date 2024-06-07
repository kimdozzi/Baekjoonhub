class Solution {
    public boolean solution(int x) {
        String s = "" + x;
        int num = 0;
        for (int i=0; i<s.length(); i++) {
            num += s.charAt(i) - '0';
        }   
        if (x % num == 0) return true;
        else return false;
    }
}