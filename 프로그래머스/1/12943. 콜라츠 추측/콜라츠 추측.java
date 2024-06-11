class Solution {
    public int solution(int num) {
        int cnt = 0;
        if (num == 1) return 0;
        while (cnt < 500) {
            if (num == 1) break;
            if (num % 2 == 0) num /= 2;
            else if (num % 2 == 1) num = (num * 3) + 1;
            cnt++;
        }
        return cnt >= 500 ? -1 : cnt;
    }
}