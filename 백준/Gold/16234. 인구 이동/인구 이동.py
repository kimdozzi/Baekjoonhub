import sys
from collections import deque
si = sys.stdin.readline

n,l,r=map(int,si().split())
board=[list(map(int,si().split())) for _ in range(n)]
dx = [0,1,0,-1]
dy = [1,0,-1,0]
days = 0

def bfs(x,y) :
    global n,board,visited
    q = deque([])
    temp = []
    q.append((x,y))
    temp.append((x,y))
    visited[x][y] = True

    while q :
        x,y = q.popleft()
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]
            if not (0<=nx<n and 0<=ny<n) : continue
            if not visited[nx][ny] and l <= abs(board[x][y]-board[nx][ny]) <= r :
                visited[nx][ny] = True
                q.append((nx,ny))
                temp.append((nx,ny))

    return temp


def move(country):
    res = 0
    for x,y in country :
        res += board[x][y]

    number = res // len(country)

    for x,y in country :
        board[x][y] = number


while True :
    flag = True
    visited = [[False]*n for _ in range(n)]

    for i in range(n) :
        for j in range(n) :
            if not visited[i][j] :
                country = bfs(i,j)
                if len(country) > 1 :
                    flag = False

                    move(country)

    if flag :
        break

    days += 1

print(days)