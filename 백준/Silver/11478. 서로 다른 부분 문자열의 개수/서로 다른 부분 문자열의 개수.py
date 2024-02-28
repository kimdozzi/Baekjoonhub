import sys
si = sys.stdin.readline

arr=list(si().rstrip())

# i = 1
# arr[i-1:i] = arr[0:1], arr[1:2] .. arr[n-1:n]
# i = 2
# arr[i-2:i] = arr[0:2], arr[1:3]
store = set()
for i in range(1,len(arr)+1) :
    for j in range(i,len(arr)+1) :
        s = "".join(arr[j-i:j])
        if s not in store :
            store.add(s)
print(len(store))
