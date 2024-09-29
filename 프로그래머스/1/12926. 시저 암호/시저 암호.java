class Solution {
    public String solution(String s, int n) {
        char[] chArr = s.toCharArray();
        char[] ans = new char[chArr.length];
        for(int i=0; i<chArr.length; i++) {
            if (65<=chArr[i] && chArr[i]<=90) {
                int num = chArr[i] + n;
                if (num > 90) {
                    ans[i] = (char)((int)(num/90) * 64 + (num%90));
                } else {
                    ans[i] = (char)num;
                }
            } 
            else if (97<=chArr[i] && chArr[i]<=122) {
                int num = chArr[i] + n;
                if (num > 122) {
                    ans[i] = (char)((int)(num/122) * 96 + (num%122));
                } else {
                    ans[i] = (char)num;
                }
            } 
            else {
                ans[i] = ' ';
            }
        }
        return String.valueOf(ans);
    }
}