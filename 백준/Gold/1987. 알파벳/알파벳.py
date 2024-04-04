import sys
si = sys.stdin.readline
n,m=map(int,si().split())
board=[list(si().rstrip()) for _ in range(n)]
dx=[0,1,0,-1]
dy=[1,0,-1,0]
ans = float('-inf')
visited = [False] * 26
visited[ord(board[0][0])-65]=True
# 2251
def backtrack(cnt,x,y) :
    global ans
    ans = max(ans, cnt)

    for i in range(4) :
        nx=x+dx[i]
        ny=y+dy[i]
        if not (0<=nx<n and 0<=ny<m) : continue
        if not visited[ord(board[nx][ny])-65] :
            visited[ord(board[nx][ny])-65] = True
            backtrack(cnt+1, nx, ny)
            visited[ord(board[nx][ny])-65] = False

backtrack(1,0,0)
print(ans)

