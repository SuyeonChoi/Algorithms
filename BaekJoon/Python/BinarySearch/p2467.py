import sys
input = sys.stdin.readline


N = int(input())
liquid = list(map(int, input().split()))

liquid = sorted(liquid)
st, en = 0, N-1
a, b = 0, 0
_min = 2000000000
while st < en:
    _sum = liquid[st] + liquid[en]
    if abs(_sum) < abs(_min):
        a, b = liquid[st], liquid[en]
        _min = a + b
    if _sum == 0:
        break
    elif _sum < 0:
        st += 1
    else:
        en -= 1

print(a, b)
