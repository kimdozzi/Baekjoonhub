import sys
from collections import defaultdict
si = sys.stdin.readline

s=list(si().rstrip())
dic=defaultdict(int)

for i in s :
    if i == '6' :
        if dic['6'] - dic['9'] >=1 :
            dic['9'] += 1
        else:
            dic[i] += 1
    elif i == '9' :
        if dic['9'] - dic['6'] >= 1 :
            dic['6'] += 1
        else :
            dic[i] += 1
    else :
        dic[i] += 1

print(max(dic.values()))