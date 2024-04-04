import sys
si = sys.stdin.readline
n,m=map(int,si().split())
lst=list(map(int,si().split()))

prefix=[0]*n
prefix[0] = lst[0]

for i in range(1,n) :
    prefix[i] = prefix[i-1]+lst[i]

ans=float('-inf')
for i in range(n-m+1) :
    if i == 0 :
        ans = max(ans, prefix[i+m-1])
    else:
        ans = max(ans ,prefix[i+m-1] - prefix[i-1])

print(ans)
