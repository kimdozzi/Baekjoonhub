import sys
si = sys.stdin.readline

l = int(si())
arr = list(map(int, si().split()))
arr.sort()
n = int(si())

x,y = 0,1001
cnt = 0

if arr[-1] < n or n in arr:
    print(0)
    exit(0)

for i in range(l) :
    if arr[i] > n :
        if i != 0 :
            x = arr[i-1]
        y = arr[i]
        break

for i in range(x+1, n+1) :
    for j in range(n, y) :
        if i == j : continue
        cnt += 1

print(cnt)