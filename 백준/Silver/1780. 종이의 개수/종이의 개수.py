import sys
si = sys.stdin.readline

n = int(si())
board = [list(map(int ,si().split())) for _ in range(n)]

dic = {-1:0,0:0,1:0}

def is_same(cur,r,c,n) :
    for i in range(r,r+n) :
        for j in range(c,c+n) :
            if board[i][j] != cur :
                return False
    return True

def rec_func(n,r,c) :
    if n == 1 or is_same(board[r][c],r,c,n):
        dic[board[r][c]] += 1
        return

    mid = n // 3
    rec_func(mid,r,c)
    rec_func(mid,r,c+mid)
    rec_func(mid,r,c+(mid*2))

    rec_func(mid,r+mid,c)
    rec_func(mid,r+mid,c+mid)
    rec_func(mid,r+mid,c+(mid*2))

    rec_func(mid,r+(mid*2),c)
    rec_func(mid,r+(mid*2),c+mid)
    rec_func(mid,r+(mid*2),c+(mid*2))


rec_func(n,0,0)

print(dic[-1],dic[0],dic[1],sep='\n')


