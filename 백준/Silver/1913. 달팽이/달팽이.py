import sys
si = sys.stdin.readline
def draw():
    global n
    x = y = n//2
    cnt = 2
    num = 1
    d = [(0,1),(1,0),(0,-1),(-1,0)]
    t = 0
    board[x][y] = num; x-=1; y-=1

    while True:
        for i in range(4):
            for _ in range(cnt):
                x+=d[i][0]; y+=d[i][1]
                num+=1
                board[x][y] = num
                if num==m:
                    ans[0]=x+1; ans[1]=y+1
        
        if x == y == 0 : return 
        x-=1; y-=1
        cnt+=2

n = int(si())
m = int(si())
board = [[0]*n for _ in range(n)]
ans = [n//2+1,n//2+1]
draw()
for i in board:
    print(*i)
print(*ans)