class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int idx = 0;
        long num = x;
        while (idx < n) {
            answer[idx++] = num;
            num += x;
        }
        
        return answer;
    }
}