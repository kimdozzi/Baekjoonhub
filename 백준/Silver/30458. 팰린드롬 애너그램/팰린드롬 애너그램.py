import collections
import sys
si = sys.stdin.readline

n = int(si())
s = list(si().rstrip())

a,b=[],[]
if n%2==0 :
    a = s[:n//2]
    b = s[n//2:]
else :
    a = s[:n // 2]
    b = s[n // 2 +1:]

dic = collections.defaultdict(int)
for i in a :
    dic[i] += 1

for i in b :
    dic[i] += 1

flag = False
for _,v in dic.items() :
    if v % 2 != 0 :
        flag = True


if not flag :
    print('Yes')
else :
    print('No')
