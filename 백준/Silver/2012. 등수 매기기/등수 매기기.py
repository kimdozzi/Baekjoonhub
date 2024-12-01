import sys
from collections import deque
si = sys.stdin.readline

n = int(si())
lst = []
for _ in range(n) :
    lst.append(int(si()))

lst.sort()

ans = 0
for k,v in enumerate(lst, 1) :
    ans += abs(k-v)

print(ans)



