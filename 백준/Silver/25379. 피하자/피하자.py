import sys
si = sys.stdin.readline

n=int(si())
arr=list(map(int,si().split()))

res1, res2 = 0,0
cnt = 0
for i in arr :
    if i % 2 == 1 :
        cnt += 1
    else :
        res1 += cnt

cnt = 0
arr.reverse()
for i in arr :
    if i % 2 == 1 :
        cnt += 1
    else :
        res2 += cnt

print(min(res1, res2))