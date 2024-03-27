import sys
si = sys.stdin.readline
n,m=map(int,si().split())

prefix_sum=[[0]*(n+1) for _ in range(n+1)]
board=[list(map(int,si().split())) for _ in range(n)]

for i in range(1,n+1) :
    for j in range(1,n+1) :
        prefix_sum[i][j] = board[i-1][j-1] + prefix_sum[i][j-1] + prefix_sum[i-1][j] - prefix_sum[i-1][j-1]

for _ in range(m) :
    r1,c1,r2,c2=map(int,si().split())
    r1-=1;c1-=1;r2-=1;c2-=1
    ans = prefix_sum[r2+1][c2+1] - prefix_sum[r2+1][c1] - prefix_sum[r1][c2+1] + prefix_sum[r1][c1]
    print(ans)
