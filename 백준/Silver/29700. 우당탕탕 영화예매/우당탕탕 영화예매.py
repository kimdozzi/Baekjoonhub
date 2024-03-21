import sys
si = sys.stdin.readline
n,m,k=map(int,si().split())
board=[list(map(int, list(si().rstrip()))) for _ in range(n)]
cnt = 0
for i in range(n) :
    for j in range(m-k+1) :
        if sum(board[i][j:j+k]) == 0 :
            cnt += 1
print(cnt)