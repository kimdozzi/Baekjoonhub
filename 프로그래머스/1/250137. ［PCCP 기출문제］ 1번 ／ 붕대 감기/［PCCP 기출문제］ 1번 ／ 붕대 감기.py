def solution(bandage, health, attacks):
    answer = 0
    max_health = health
    t,x,y = bandage
    max_time = attacks[-1][0] # 최대 진행 시간
    cnt = 0 # 연속 붕대감기 성공
    attack_cnt = 0 # 몬스터의 공격 순서 
    
    for time in range(1, max_time+1) :
        if attacks[attack_cnt][0] == time : 
            health -= attacks[attack_cnt][1] 
            attack_cnt += 1
            cnt = 0
            if health <= 0 : return -1
        else : 
            health = min(max_health, health + x) # 최대 체력보다 높아지지 않음 
            cnt += 1
            if cnt == t : # 연속 성공이 붕대 감기 t초에 도달한다면 
                health = min(max_health, health + y)
                cnt = 0
    if health <= 0 : return -1 
    return health 