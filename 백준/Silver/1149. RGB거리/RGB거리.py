import sys

si = sys.stdin.readline

n = int(si())
lst = [list(map(int, si().split())) for _ in range(n)]

dp = [[0] * 4 for _ in range(n + 1)]
dp[1][1] = lst[0][0]
dp[1][2] = lst[0][1]
dp[1][3] = lst[0][2]

for i in range(2, n+1):
    dp[i][1] = lst[i-1][0] + min(dp[i - 1][2], dp[i - 1][3])
    dp[i][2] = lst[i-1][1] + min(dp[i - 1][1], dp[i - 1][3])
    dp[i][3] = lst[i-1][2] + min(dp[i - 1][2], dp[i - 1][1])

print(min(dp[n][1:]))