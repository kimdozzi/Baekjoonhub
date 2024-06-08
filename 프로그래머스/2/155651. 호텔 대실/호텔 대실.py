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

# from collections import defaultdict

# def to_time(val) :
#     h, m = map(int,val.split(":"))
#     return h * 60 + m
    
# def solution(book_time):
#     book = defaultdict(int)
#     for i in range(len(book_time)) :
#         s,e = book_time[i]
#         book[to_time(s)] += 1
#         book[to_time(e)+10] += -1
    
#     book = sorted(book.items(), key=lambda x : x[0])
    
#     mx = float('-inf')
#     cur = 0
#     for b in book : 
#         cur += b[1]
#         mx = max(mx, cur)
    
#     return mx

