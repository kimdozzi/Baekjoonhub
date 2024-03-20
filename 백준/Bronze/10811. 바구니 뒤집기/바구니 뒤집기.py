import sys
si = sys.stdin.readline
n,m=map(int,si().split())
arr = [i for i in range(1,n+1)]
for _ in range(m) :
    a,b=map(int,si().split())
    a,b=a-1,b-1
    arr[a:b+1] = arr[a:b+1][::-1]
print(*arr,sep=' ')