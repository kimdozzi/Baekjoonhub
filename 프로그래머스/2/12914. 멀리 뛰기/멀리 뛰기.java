class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[2001];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<2001; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }
        return dp[n];
    }
}
/*
d[0] = 1
d[1] = 1
d[2] = d[i-2] + dp[i-1] 


*/