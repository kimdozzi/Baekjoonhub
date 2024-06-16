import sys

si = sys.stdin.readline


def func(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
        return 1

    if a > 20 or b > 20 or c > 20:
        return func(20, 20, 20)

    if arr[a][b][c] : return arr[a][b][c]

    if a < b < c:
        arr[a][b][c] = func(a, b, c - 1) + func(a, b - 1, c - 1) - func(a, b - 1, c)

    else:
        arr[a][b][c] = func(a - 1, b, c) + func(a - 1, b - 1, c) + func(a - 1, b, c - 1) - func(a - 1, b - 1, c - 1)

    return arr[a][b][c]

arr = [[[0] * 21 for _ in range(21)]  for _ in range(21)]

while True :
    a, b, c = map(int, si().split())
    if a == -1 and b == -1 and c == -1 : break

    print(f'w({a}, {b}, {c}) = {func(a,b,c)}')