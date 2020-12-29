import sys, math
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    d = math.pow(x1-x2, 2) + math.pow(y1-y2, 2)
    if r1 > r2:
        tmp = r1
        r1 = r2
        r2 = tmp
    sub = math.pow(r2-r1, 2)
    add = math.pow(r2+r1, 2)
    if (sub < d) and (d < add):
        print(2)
    elif add == d:
        print(1)
    elif d != 0 and d == sub:
        print(1)
    elif (d < sub) or (d > add):
        print(0)
    elif d == 0:
        if r1 == r2:
            print(-1)
        else:
            print(0)
