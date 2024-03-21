import sys
from collections import defaultdict
si = sys.stdin.readline
s,p=map(int,si().split())
strList=list(si().rstrip())
arr = list(map(int, si().split()))

if s < p :
    print(0)
    exit(0)

arr_dic = defaultdict(int)
idx = 0
for i in ['A','C','G','T'] :
    arr_dic[i] += arr[idx]
    idx+=1

dic={'A':0, 'C':0, 'G':0, 'T':0}
for i in strList[:p] :
    dic[i] += 1
cnt = 0
for k,v in arr_dic.items() :
    if k in dic :
        if dic[k] >= arr_dic[k] :
            cnt += 1

cnt = 1 if cnt==4 else 0

# print(arr_dic, dic, cnt)

def check() :
    global arr_dic, dic
    temp = 0
    for k in arr_dic.keys():
        if k in dic :
            if dic[k] >= arr_dic[k] :
                temp += 1
    return True if temp==4 else False

for i in range(s-p+1) :
    if i == 0 : continue
    dic[strList[i-1]] -= 1
    dic[strList[i+p-1]] += 1
    if check() :
        cnt+=1

print(cnt)



