import sys
si = sys.stdin.readline

l = int(si())
arr = list(map(int, si().split()))
arr.sort()
n = int(si())

if n in arr or arr[-1] < n:
    print(0)
    exit(0)

x,y=0,1001
for i in range(len(arr)) :
    if i == 0 and arr[i] > n :
        y = arr[i]
        break

    if arr[i] > n :
        x = arr[i-1]
        y = arr[i]
        break

cnt = 0
flag = False
for i in range(x+1, n+1) :
    if flag :
        break
    for j in range(n, y) :
        if i == j : continue
        cnt += 1

print(cnt)
