import sys
input = sys.stdin.readline
n = int(input())
fibbo = [0] * (n+1)
for i in range(1, n+1):
    if i == 1:
        fibbo[1] = 1
    elif i == 2:
        fibbo[2] = 1
    else:
        fibbo[i] = fibbo[i-1] + fibbo[i-2]
print(fibbo[n])