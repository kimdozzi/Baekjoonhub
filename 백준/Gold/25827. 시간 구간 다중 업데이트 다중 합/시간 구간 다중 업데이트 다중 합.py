import sys
si = sys.stdin.readline
n = int(si())
sz = 24*60*60
arr = [0] * (sz+1)
imos = [0] * (sz+1)
flag = False

def init() :
    global flag, sz

    if flag : return
    flag = True

    for i in range(1,sz+1) :
        arr[i] += arr[i-1]
        imos[i] = imos[i-1] + arr[i]

for _ in range(n) :
    types, start, end = si().split()
    start_hour, start_min, start_sec = list(map(int,start.split(":")))
    end_hour, end_min, end_sec = list(map(int,end.split(":")))

    s_time = start_hour*3600 + start_min*60 + start_sec
    e_time = end_hour*3600 + end_min*60 + end_sec

    s_time, e_time = s_time+1, e_time+1 # 1부터 시작하도록 1칸 이동

    if types == '1' :
        arr[s_time] += 1
        arr[e_time] -= 1

    else :
        init()
        print(imos[e_time-1] - imos[s_time-1])
