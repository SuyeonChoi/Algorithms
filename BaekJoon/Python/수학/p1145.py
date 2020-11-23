from math import gcd
from itertools import combinations
import sys
input = sys.stdin.readline

def lcm(x, y):
    return x * y // gcd(x, y)


numList = sorted(list(map(int, input().split())))
ans = lcm(lcm(numList[0], numList[1]), numList[2])

for x, y, z in combinations([0, 1, 2, 3, 4], 3):
    tmp = lcm(lcm(numList[x], numList[y]), numList[z])
    if tmp < ans:
        ans = tmp
print(ans)


