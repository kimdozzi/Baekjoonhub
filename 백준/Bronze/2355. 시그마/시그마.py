import sys
si = sys.stdin.readline

n,m=map(int,si().split())
if n > m : n,m = m,n
print(((m+1)*(m)//2)-((n-1)*(n)//2))

