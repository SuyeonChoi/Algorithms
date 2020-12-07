A, B = map(str, input().split())
cnt = 0
A = list(A)
B = list(B)
_min = len(A)
for i in range(len(B)-len(A)+1):
    cnt = 0
    for a, b in zip(A, B[i:]):
        if a != b:
            cnt += 1
    if _min > cnt:
        _min = cnt

print(_min)