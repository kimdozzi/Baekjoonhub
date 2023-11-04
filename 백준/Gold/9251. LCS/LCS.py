import sys
si = sys.stdin.readline

a = list(si().rstrip())
b = list(si().rstrip())

if len(a) > len(b) :
    b += ['.'] * (len(a) - len(b))
elif len(b) > len(a) :
    a += ['.'] * (len(b) - len(a))



lcs = [[0 for _ in range(len(a)+1)] for _ in range(len(a)+1)]
# print(lcs)

for i in range(1, len(a)+1) :
    for j in range(1, len(a)+1) :
        if b[i-1] == a[j-1] :
            lcs[i][j] = lcs[i-1][j-1] + 1
        else :
            lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1])

#for i in lcs :
#    print(i)

i = len(a)
j = len(b)
print(lcs[i][j])
ans = []
while lcs[i][j] != 0 :
    if lcs[i-1][j] == lcs[i][j] :
        i = i - 1
        j = j
        continue

    elif lcs[i][j-1] == lcs[i][j] :
        i = i
        j = j - 1
        continue

    if lcs[i-1][j] != lcs[i][j] and lcs[i][j-1] != lcs[i][j] :
        ans.append(lcs[i][j])
        i = i - 1
        j = j - 1

# print(sorted(ans, reverse=True))

