import sys
from collections import deque
si = sys.stdin.readline
r,c=map(int,si().split())
graph=[list(si().rstrip()) for _ in range(r)]

visited=[[False]*c for _ in range(r)]
dirs =[[0,0],[0,1],[0,-1],[1,0],[-1,0]]
sheep, wolf = 0,0
s_sum, w_sum = 0,0

def bfs(x,y) :
    global s_sum, w_sum
    q = deque([(x,y)])

    while q :
        x,y = q.popleft()
        for i in range(5) :
            nx = x + dirs[i][0]
            ny = y + dirs[i][1]
            if not (0 <= nx < r and 0 <= ny < c) : continue
            if graph[nx][ny] == '#' : continue

            if not visited[nx][ny] :
                visited[nx][ny] = True
                if graph[nx][ny] == 'o' :
                    s_sum += 1
                elif graph[nx][ny] == 'v' :
                    w_sum += 1
                q.append((nx,ny))

for i in range(r) :
    for j in range(c) :
        if graph[i][j] == '#' :
            visited[i][j] = True
            continue

        if not visited[i][j] :
            bfs(i,j)
        if s_sum>0 or w_sum>0 :
            if s_sum > w_sum :
                sheep += s_sum
            else :
                wolf += w_sum
        s_sum, w_sum = 0, 0

print(sheep, wolf)