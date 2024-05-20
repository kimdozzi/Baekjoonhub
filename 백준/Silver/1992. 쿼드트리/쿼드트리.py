import sys
si = sys.stdin.readline

def is_same(cur, r,c,n, board) :
    for i in range(r,r+n) :
        for j in range(c,c+n) :
            if cur != board[i][j] :
                return False
    return True

def rec_func(N, r, c, arr, board) :
    if N == 1 or is_same(board[r][c], r, c, N, board) :
        arr.append(board[r][c])
        return

    mid = N//2
    arr.append('(')
    rec_func(mid, r, c, arr, board)
    rec_func(mid, r, c+mid, arr, board)

    rec_func(mid, r+mid, c, arr, board)
    rec_func(mid, r+mid, c+mid, arr, board)
    arr.append(')')


def main():
    N = int(si())
    board = [list(si().rstrip()) for _ in range(N)]
    arr = []

    rec_func(N,0,0,arr,board)

    print(*arr,sep='')


if __name__ == "__main__":
    main()

