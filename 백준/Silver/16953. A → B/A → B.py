import sys
from collections import deque
si = sys.stdin.readline
a,b=map(int,si().split())
max_num = 10**9
def bfs(x,cnt) :
    q=deque([])
    q.append((x,cnt))

    while q:
        x,cnt = q.popleft()
        if x == b :
            print(cnt)
            exit(0)
        if x > max_num :
            continue

        q.append((x*2,cnt+1))
        q.append((int(str(x)+'1'),cnt+1))


bfs(a,1)

print(-1)