import sys
input = sys.stdin.readline

nA, nB = map(int, input().split())
setA = (set(map(int, input().split())))
setB = set(map(int, input().split()))
ans = sorted(list(setA - setB))
if len(ans):
    print(len(ans))
    print(' '.join(map(str, ans)))
else:
    print(0)
