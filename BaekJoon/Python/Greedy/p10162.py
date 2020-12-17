import sys
input = sys.stdin.readline


T = int(input())
a, b, c = 0, 0, 0
if T >= 300:
    a = T // 300
    T = T % 300
if T >= 60:
    b += (T // 60)
    T = T % 60
if T >= 10:
    c += (T // 10)
    T = T % 10

if T:
    print(-1)
else:
    print(a, b, c)
