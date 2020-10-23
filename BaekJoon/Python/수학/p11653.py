import sys
input = sys.stdin.readline

N = int(input())

#최적화 이전
# i = 2
# while N != 1:
#     if N % i == 0:
#         N /= i
#         print(i)
#         continue
#     i += 1

for i in range(2, N):
    if i * i > N:
        break
    while N % i == 0:
        print(i)
        N //= i
if N != 1:
    print(N)

