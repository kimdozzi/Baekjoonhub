class Solution {
    static int[] dp;
    public int solution(int n) {
        int answer = 0;
        dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;
        
        answer = fibo(n);   
        return answer;
    }
    private static int fibo(int x) {
        if (x < 2 || dp[x] > 0) {
            return dp[x];
        }
        
        return dp[x] = (fibo(x-1) + fibo(x-2)) % 1234567;
    }
}