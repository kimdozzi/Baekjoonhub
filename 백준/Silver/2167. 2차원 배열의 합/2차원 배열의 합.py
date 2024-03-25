import sys
si = sys.stdin.readline
n,m=map(int,si().split())
arr=[list(map(int,si().split())) for _ in range(n)]

prefixSum=[[0] * (m+1) for _ in range(n+1)]

for i in range(1,n+1) :
    for j in range(1,m+1) :
        prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + arr[i-1][j-1]

k=int(si())
for _ in range(k) :
    i,j,x,y=map(int,si().split())
    print(prefixSum[x][y]-prefixSum[i-1][y]-prefixSum[x][j-1]+prefixSum[i-1][j-1])
