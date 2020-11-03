from math import factorial
N = int(input())

N = list(str(factorial(N)))
cnt = 0
for i in reversed(N):
    if i != '0':
        break
    cnt += 1

print(cnt)