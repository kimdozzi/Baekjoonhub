import sys
from collections import deque
si = sys.stdin.readline

def inRange(nx,ny) :
    return 0 <= nx < m and 0 <= ny < n

def bfs(x,y) :
    q = deque([])
    q.append((x,y))
    visited[x][y] = True
    cnt = 1
    while q :
        x,y = q.popleft()
        for d in range(4) :
            nx, ny = x + dirs[d][0], y + dirs[d][1]
            if not inRange(nx,ny) : continue
            if visited[nx][ny] : continue

            if board[x][y] == board[nx][ny] :
                visited[nx][ny] = True
                cnt += 1
                q.append((nx,ny))

    return cnt*cnt



n,m = map(int, si().split())
board = []
dirs = [[0,1],[0,-1],[1,0],[-1,0]]
for i in range(m) :
    board.append(list(map(str, si().strip())))

visited = [[False] * n for _ in range(m)]
w = b = 0
for i in range(m):
    for j in range(n) :
        if not visited[i][j] :
            total = bfs(i,j)
            if board[i][j] == 'W' :
                w += total
            else:
                b += total

print(w, b)