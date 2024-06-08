def to_time(val) :
    h, m = map(int,val.split(":"))
    return h * 60 + m
    
def solution(book_time):
    prefix_sum = [0] * 1000000
    for i in range(len(book_time)) :
        s,e = book_time[i]
        s,e = to_time(s), to_time(e)
        prefix_sum[int(s)] += 1
        prefix_sum[int(e)+10] += -1
    
    for i in range(1, 1000000) :
        prefix_sum[i] += prefix_sum[i-1]
    
    return max(prefix_sum)

