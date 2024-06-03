import sys
si = sys.stdin.readline

n,c=map(int,si().split())
arr=[int(si()) for _ in range(n)]
arr.sort()

lo,hi= 1, arr[-1]-arr[0]
result = 0

while lo <= hi :
    mid = (lo+hi)//2
    count = 1
    cur = arr[0]

    for i in range(1, n) :
        if arr[i]-cur >= mid :
            cur = arr[i]
            count += 1
    if count >= c :
        result = mid
        lo = mid + 1
    else :
        hi = mid - 1

print(result)