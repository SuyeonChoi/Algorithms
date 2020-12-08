import sys
input = sys.stdin.readline
A, B = map(int, input().split())
num = [[0 for _ in range(2)] for _ in range(B+1)]
num[1][0] = 1
num[1][1] = 1
cnt = 0
if A == 1:
    cnt = 1
for i in range(2, B+1):
    if num[i-1][0] == num[i-1][1]:
        num[i][0] = num[i-1][0] + 1
        num[i][1] = 1
    else:
        num[i][0] = num[i-1][0]
        num[i][1] = num[i-1][1] + 1
    if A <= i:
        cnt += num[i][0]
print(cnt)
# print(num)