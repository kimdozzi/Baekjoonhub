import sys
si = sys.stdin.readline
ans = []
for i in range(5):
    s = si().rstrip()
    ans.append(s)
for i in range(15) :
    for j in range(5) :
        if i < len(ans[j]) :
            print(ans[j][i],end='')
