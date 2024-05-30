from collections import defaultdict

def solution(friends, gifts):
    answer = 0
    lst = [[0] * len(friends) for _ in range(len(friends))]
    dic = defaultdict(int)
    get_gift = [0 for _ in range(len(friends))]
    gift_point = [0 for _ in range(len(friends))]
    
    for i in range(len(friends)) :
        dic[friends[i]] += i 
    
    for gift in gifts : 
        f, t = gift.split(" ")
        lst[dic[f]][dic[t]] += 1
        
    for i in range(len(lst)) :
        get = sum(lst[i]) # 받은 선물 
        post = 0
        for j in range(len(lst)) :
            if i == j : continue
            post += lst[j][i]
        gift_point[i] = get - post
    
    for i in range(len(lst)) :
        for j in range(len(lst[i])) :
            if i == j : continue
            if lst[i][j] > lst[j][i] : # A가 B에게 더 많이 줬다면 1개 받음
                get_gift[i] += 1
            elif (lst[i][j] == 0 and lst[j][i] == 0) or lst[i][j] == lst[j][i] :
                if gift_point[i] > gift_point[j] :
                    get_gift[i] += 1
    
    
    return max(get_gift)