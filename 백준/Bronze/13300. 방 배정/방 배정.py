n, k = map(int, input().split())
st = [[0]*2 for _ in range(6)] #성별2개 6학년

#입력
for _ in range(n):
    # st[학년][성별]
    s,y= map(int, input().split())
    st[y-1][s-1] += 1
#    print(st[y-1][s-1])

room_num=0
for a in range(6):#학년
    for b in range(2):#성별
        #print(st[a][b])
        #math.ceil써도 :)
        if(st[a][b]%k == 0):
            room_num += st[a][b]/k
        else:
            room_num += st[a][b]//k + 1
print(int(room_num))