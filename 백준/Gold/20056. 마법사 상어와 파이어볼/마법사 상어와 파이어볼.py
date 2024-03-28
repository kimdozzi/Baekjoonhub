import sys
from collections import deque

def move() :
    while fireballs :
        x, y, weight, speed, direction = fireballs.popleft()
        nx = (x + speed * dx[direction]) % N
        ny = (y + speed * dy[direction]) % N
        board[nx][ny].append([weight, speed, direction])

def merge_and_divide(i, j) :
    sum_weight, sum_speed, cnt_odd, cnt_even, board_cnt = 0, 0, 0, 0, len(board[i][j])
    while board[i][j] :
        mm, ss, dd = board[i][j].pop(0)
        sum_weight += mm
        sum_speed += ss
        if dd % 2 == 1 :
            cnt_odd += 1
        else :
            cnt_even += 1

    if cnt_odd == board_cnt or cnt_even == board_cnt :
        nd = [0,2,4,6]
    else :
        nd = [1,3,5,7]

    if (sum_weight // 5) >= 1 :
        for d in nd :
            fireballs.append([i,j,sum_weight//5, sum_speed//board_cnt, d])


def check() :
    for i in range(N) :
        for j in range(N) :
            if len(board[i][j]) > 1 :
                merge_and_divide(i,j)

            if len(board[i][j]) == 1 :
                fireballs.append([i,j]+board[i][j].pop())


si = sys.stdin.readline
N,M,K=map(int,si().split())
fireballs = deque([])
board=[[[] for _ in range(N)]  for _ in range(N)]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

for _ in range(M) :
    _r, _c, _m, _s, _d = map(int,si().split())
    fireballs.append([_r-1, _c-1, _m, _s, _d])

for _ in range(K) :
    # 1.
    move()
    # 2.
    check()

print(sum([ val[2] for val in fireballs ]))

