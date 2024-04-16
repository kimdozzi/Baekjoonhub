import sys
from collections import deque
si = sys.stdin.readline

n=int(si())
trees = [[] for _ in range(n+1)]
visited= [False for _ in range(n+1)]
cnt = 0

for _ in range(n-1) :
    a,b=map(int,si().split())
    trees[a].append(b)
    trees[b].append(a)

def bfs() :
    global cnt
    q = deque([])
    q.append((0, 1)) # depth, cur_node
    visited[1] = True

    while q :
        depth, curNode = q.popleft()

        isLeaf = True
        for node in trees[curNode] :
            if not visited[node] :
                isLeaf = False
                visited[node] = True
                q.append((depth+1, node))

        if isLeaf :
            cnt += depth

bfs()

print("Yes") if cnt % 2 == 1 else print("No")