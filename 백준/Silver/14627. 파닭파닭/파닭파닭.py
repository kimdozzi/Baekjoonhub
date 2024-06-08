import sys
si = sys.stdin.readline

a, b = map(int, si().split())
arr = [int(si()) for _ in range(a)]
ans = []
s, e = 1, max(arr)
while s <= e:
    mid = (s + e) // 2
    cnt = 0
    for i in range(len(arr)):
        cnt += arr[i] // mid

    if cnt >= b:
        s = mid+1
        ans.append(mid)
    else:
        e = mid-1

print(sum(arr)-(b*max(ans)))
