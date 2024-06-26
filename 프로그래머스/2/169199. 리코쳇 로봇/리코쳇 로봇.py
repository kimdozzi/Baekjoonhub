from collections import deque

dirs = [[0,1],[0,-1],[1,0],[-1,0]]
    
def search(board) :
    for i in range(len(board)) :
        for j in range(len(board[i])) :
            if board[i][j] == 'G' :
                ax,ay = i,j
            if board[i][j] == 'R' : 
                rx,ry=i,j
    return rx,ry,ax,ay


def bfs(x,y,ax,ay,board):
    global r,c,visited
    q = deque([(x,y,0)])
    visited[x][y] = True
    
    while q :
        x, y, move = q.popleft()
        for i in range(4) :
            nx = x + dirs[i][0]
            ny = y + dirs[i][1]
            while (0 <= nx < r and 0 <= ny < c) and board[nx][ny] != 'D':
                nx += dirs[i][0]
                ny += dirs[i][1]
            
            nx,ny = nx - dirs[i][0], ny - dirs[i][1]
            
            if board[nx][ny] == board[ax][ay] : 
                return move+1
            
            if not visited[nx][ny] : 
                visited[nx][ny] = True
                q.append((nx,ny,move+1))
    return -1 
        

def solution(board):
    global r,c,visited
    visited = [[False] * len(board[0]) for _ in range(len(board))]
    r,c = len(board), len(board[0])
    rx,ry,ax,ay = search(board)
    
    answer = bfs(rx,ry,ax,ay,board)
    
    return answer