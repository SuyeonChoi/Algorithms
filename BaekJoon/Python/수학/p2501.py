import sys
input = sys.stdin.readline
N, K = map(int, input().split())

staticN = N
measure = []
#1부터 N까지 모든 수에 대해 N을 나누는지 확인하는 방법:O(N)
# for i in range(1, staticN+1):
#     if N % i == 0:
#         measure.append(i)
# if len(measure) < K:
#     print(0)
# else:
#     print(measure[K-1])
import math
#약수끼리의 곱이 N이 되게끔 짝을 짓는 방법:O(루트N)
for i in range(1, N):
    if i * i > N:
        break
    if N % i == 0:
        measure.append(i)
for i in range(len(measure)-1, -1, -1):
    if measure[i] * measure[i] == N:
        continue
    measure.append(N // measure[i])
if len(measure) < K:
    print(0)
else:
    print(measure[K-1])
