import sys

si = sys.stdin.readline

n,l = map(int, si().split())

ans = int('1'*(l-1)+str(n))
print(ans)