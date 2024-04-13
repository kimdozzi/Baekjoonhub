import sys, math
si = sys.stdin.readline

n,m,k=map(int, si().split())
arr=[int(si()) for _ in range(n)]
sz = math.ceil(math.log(n,2))
MAX_ST = 2 ** sz
seg_arr = [0 for _ in range(MAX_ST*2)]

def construct_leaf() :
    for i in range(MAX_ST, MAX_ST*2) :
        if i-MAX_ST >= n :
            seg_arr[i] = 0
        else:
            seg_arr[i] = arr[i-MAX_ST]

def construct() :
    for i in range(MAX_ST-1, 0, -1) :
        seg_arr[i] = seg_arr[i*2] + seg_arr[i*2+1]

def get_sum(L, R, nodeNum, curNodeL, curNodeR) :
    if R < curNodeL or curNodeR < L : return False
    if L <= curNodeL and curNodeR <= R : return seg_arr[nodeNum]

    mid = (curNodeL + curNodeR) // 2
    return get_sum(L, R, nodeNum*2, curNodeL, mid) + get_sum(L, R, nodeNum*2+1, mid+1, curNodeR)

def update(idx, val) :
    idx += MAX_ST
    seg_arr[idx] = val
    while idx > 1 :
        idx //= 2
        seg_arr[idx] = seg_arr[idx*2] + seg_arr[idx*2+1]

construct_leaf()
construct()

for _ in range(m+k) :
    a,b,c=map(int,si().split())
    if a == 1 :
        # b -> c 로 변경
        update(b-1, c)
    elif a == 2 :
        # [b,c] 까지 합 출력
        print(get_sum(b-1,c-1,1,0,MAX_ST-1))