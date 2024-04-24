import sys
si = sys.stdin.readline

n = int(si())
board = [list(si().rstrip()) for _ in range(n)]

connected = [[0] * n for _ in range(n)]


for k in range(n):
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            if board[i][j] == "Y" or (board[i][k] == "Y" and board[k][j] == "Y"):
                connected[i][j] = 1

ans = 0
for r in connected :
    ans = max(ans, sum(r))
print(ans)