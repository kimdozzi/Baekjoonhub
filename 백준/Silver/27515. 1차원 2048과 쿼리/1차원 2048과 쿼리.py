N,*A=open(0)
arr=[0]*64
for k in A:
 if k[:2]in "-0+0":1
 elif k[0]=="+":
  arr[len(bin(int(k[1:])))-2]+=1
 else:
  arr[len(bin(int(k[1:])))-2]-=1
 tmp=arr[:]
 for i in range(63):
  tmp[i+1]+=tmp[i]//2
 if sum(tmp)==0:print(0)
 else:print(1<<max(i for i in range(64)if tmp[i])-1)