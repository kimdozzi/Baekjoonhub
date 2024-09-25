class Solution {
    public int solution(int n) {

        int num = 1;
        int idx = 1;
        while (num < n) {
            num *= idx;
            if (num >= n) {
                break;
            }
            idx++;
        }
        
        return (num > n) ? (idx-1) : idx;
        
    }
}