import sys
from collections import deque

si = sys.stdin.readline

L, R = map(int, si().split())

arr = [i for i in range(L, R + 1)]

def calculate(num):
    q = deque([num])
    store = [num]
    cnt = 0
    while q:
        total, mul = 0, 1
        x = q.popleft()

        if x > 100000:
            return -1

        cnt += 1
        tmp = str(x)

        for i in tmp:
            total += int(i)
        for i in tmp:
            mul *= int(i)

        temp = int(str(total) + str(mul))

        if x == temp :
            store.append(temp)
            return 1

        if x != temp and temp in store :
            return 0

        q.append(temp)
        store.append(temp)

    return 0

ans = 0

for i in arr:
    ans += calculate(i)

print(ans)
