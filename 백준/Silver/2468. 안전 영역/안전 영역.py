import sys
from collections import deque
si = sys.stdin.readline

def get_max_water(board: list) -> int:
    temp = -1
    for i in board:
        temp = max(temp, max(i))
    return temp



def bfs(i: int, j: int, water_depth: int, visited: list, n: int, board:list):
    dirs = [[0,1],[0,-1],[1,0],[-1,0]]
    q = deque()
    q.append((i,j))
    visited[i][j] = True

    while q :
        x,y = q.popleft()
        for i in range(4) :
            nx = x + dirs[i][0]
            ny = y + dirs[i][1]
            if not (0 <= nx < n and 0 <= ny < n) : continue
            if visited[nx][ny] or board[nx][ny] <= water_depth : continue
            q.append((nx, ny))
            visited[nx][ny] = True

    return True


def solve(water_depth: int, board: list, n: int) -> int:
    visited = [[False] * n for _ in range(n)]
    cnt = 0
    for i in range(n) :
        for j in range(n) :
            if board[i][j] <= water_depth :
                visited[i][j] = True

    for i in range(n) :
        for j in range(n) :
            if not visited[i][j] and board[i][j] > water_depth :
                if bfs(i,j,water_depth,visited, n, board) :
                    cnt += 1
    return cnt


def main() :
    n = int(si()) # max 100
    board = [list(map(int, si().split())) for _ in range(n)]
    ans = 0
    max_water = get_max_water(board) # max 100


    for i in range(max_water) :
        ans = max(ans, solve(i, board, n))

    print(ans)

if __name__ == "__main__" :
    main()

