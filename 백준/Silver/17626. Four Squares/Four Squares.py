import sys
si = sys.stdin.readline

n = int(si())
dp = [0] * (n+1)

k=1
while k*k <= n :
    dp[k*k] = 1
    k += 1

for i in range(1,n+1) :
    if dp[i] != 0 : continue

    j = 1
    while j*j <= i :
        # dp[i] = 자연수 i를 만들기 위한 제곱수의 개수
        if dp[i] == 0 :
            dp[i] = dp[j*j] + dp[i - j*j]
        else :
            dp[i] = min(dp[i], dp[j*j] + dp[i - j*j])
        j += 1

print(dp[n])