import sys
si = sys.stdin.readline
a = list(si().rstrip())
b = list(si().rstrip())

if len(a) > len(b) :
    b += ['.'] * (len(a) - len(b))
elif len(a) < len(b) :
    a += ['.'] * (len(b) - len(a))

lcs = [[0 for _ in range(len(a)+1)] for _ in range(len(a)+1)]

for i in range(1, len(a)+1) :
    for j in range(1, len(a)+1) :
        if a[i-1] == b[j-1] :
            lcs[i][j] = lcs[i-1][j-1] + 1
        else :
            lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1])

i = len(a)
j = len(a)
print(lcs[i][j])
if lcs[i][j] == 0 : exit(0)
ans = []
while lcs[i][j] != 0 :
    if lcs[i-1][j] == lcs[i][j] :
        i = i - 1
    elif lcs[i][j-1] == lcs[i][j] :
        j = j - 1
    else:
        ans.append(a[i-1])
        i = i - 1
        j = j - 1


print(*ans[::-1], sep='')


