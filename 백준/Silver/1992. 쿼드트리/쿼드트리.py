import sys
si = sys.stdin.readline

n = int(si())
board = [list(map(int, si().rstrip())) for _ in range(n)]


def rec_func(r,c,length) :
    if isSame(r,c,length) :
        print(board[r][c],end='')
        return

    mid = length // 2
    print('(',end='')
    rec_func(r,c,mid)
    rec_func(r,c+mid,mid)
    rec_func(r+mid,c,mid)
    rec_func(r+mid,c+mid,mid)
    print(')',end='')


def isSame(r,c,length) :
    for i in range(length) :
        for j in range(length) :
            if board[r][c] != board[r+i][c+j] :
                return False
    return True

rec_func(0,0,n)
