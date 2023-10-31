import sys
from collections import defaultdict
si = sys.stdin.readline

n = int(si())
arr = list(map(int, si().split()))
checked = [0] * 4

for i in arr :
    checked[i] += 1

i = 0
ans = 0
while i < len(arr) :
    if checked[0] > 0 and checked[3] > 0 :
        checked[0] -= 1
        checked[3] -= 1
        ans += 3

    if checked[1] > 0 and checked[2] > 0 :
        checked[1] -= 1
        checked[2] -= 1
        ans += 3
    i+=1

tmp = []
for i in range(len(checked)) :
    if checked[i] > 0 :
        while checked[i] > 0 :
            tmp.append(i)
            checked[i] -= 1

while len(tmp) >= 2 :
    ans += tmp.pop(0) ^ tmp.pop()

print(ans)


