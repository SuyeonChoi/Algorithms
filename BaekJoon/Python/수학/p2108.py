import sys
import math
input = sys.stdin.readline
N = int(input())
num = []
freq = dict()
for i in range(N):
    value = int(input())
    num.append(value)
    if value in freq:
        freq[value] += 1
    else:
        freq[value] = 1

num = sorted(num)
_max = max(list(freq.values()))
findMax = []
for i in freq.keys():
    if freq[i] == _max:
        findMax.append(i)


print(round(sum(num)/N))
print(num[N//2])

if len(findMax) >= 2:
    print(sorted(findMax)[1])
else:
    print(findMax[0])

print(num[-1] - num[0])