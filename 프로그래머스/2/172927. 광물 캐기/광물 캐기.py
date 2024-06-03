from collections import defaultdict
def solution(picks, minerals):
    cnt = 0
    for pick in picks : 
        cnt += pick
    
    if len(minerals) > cnt*5 : 
        minerals = minerals[:cnt*5]
    
    items = [[0, 0, 0] for _ in range(10)]
    for i in range(len(minerals)) :
        if minerals[i][0] == 'd' :
            items[i//5][0] += 1
        elif minerals[i][0] == 'i' :
            items[i//5][1] += 1
        else :
            items[i//5][2] += 1
    
    sorted_items = sorted(items, key=lambda x: (-x[0], -x[1], -x[2]))
    
    answer = 0
    for val in sorted_items :
        d, i, s = val
        for p in range(len(picks)) :
            if p == 0 and picks[p] > 0 :
                picks[p] -= 1
                answer += d + i + s
                break
            elif p == 1 and picks[p] > 0 :
                picks[p] -= 1
                answer += (d*5) + i + s
                break
            elif p == 2 and picks[p] > 0 :
                picks[p] -= 1
                answer += (d*25) + (i*5) + s
                break
        
    return answer








