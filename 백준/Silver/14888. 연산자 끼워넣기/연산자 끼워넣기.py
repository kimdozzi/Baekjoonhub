import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
operator = list(map(int, input().split()))  # + - * %
ans = []
visit = [False for _ in range(len(operator))]
mx = float('-inf')
mn = float('inf')


def rec_func(depth):
    if depth == N-1:
        total = arr[0]
        idx = 0
        for i in range(1, len(arr)):
            op = ans[idx]
            if op == 0:
                total += arr[i]
            elif op == 1:
                total -= arr[i]
            elif op == 2:
                total *= arr[i]
            elif op == 3:
                total = int(total / arr[i])
            idx += 1
        global mx, mn
        mx = max(mx, total)
        mn = min(mn, total)
        return

    else:
        for i in range(len(operator)):
            if operator[i]:
                operator[i] -= 1
                ans.append(i)
                rec_func(depth+1)
                ans.pop()
                operator[i] += 1


rec_func(0)
print(mx)
print(mn)
