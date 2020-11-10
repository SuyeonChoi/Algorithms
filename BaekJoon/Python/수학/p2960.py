import sys
input = sys.stdin.readline

N, K = map(int, input().split())
num = [True for i in range(N+1)]
cnt = 0
for i in range(2, N+1):
    if not num[i]:
        continue
    num[i] = False
    cnt += 1
    if cnt == K:
        print(i)
        break
    for j in range(i+i, N+1, i):
        if num[j]:
            num[j] = False
            cnt += 1
        if cnt == K:
            print(j)
            break