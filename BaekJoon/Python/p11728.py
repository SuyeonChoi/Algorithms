N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
result = list()
a = 0
b = 0
while a < N and b < M:
    if A[a] > B[b]:
        result.append(B[b])
        b += 1
    else:
        result.append(A[a])
        a += 1

while a < N:
    result.append(A[a])
    a += 1
while b < M:
    result.append(B[b])
    b += 1
for i in range(len(result)):
    print(result[i], end=' ')
