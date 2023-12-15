import sys
si = sys.stdin.readline

n = int(si())
tower_list=list(map(int, si().split()))
stk = []
ans = []

for i in range(n) :
    # 수신가능한 탑이 있다면
    while stk :
        if stk[-1][1] > tower_list[i] :
            ans.append(stk[-1][0] + 1)
            break
        else :
            stk.pop()

    if not stk :
        ans.append(0)
    stk.append([i, tower_list[i]])

print(" ".join(map(str, ans)))
