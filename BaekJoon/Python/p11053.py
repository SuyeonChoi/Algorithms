N = int(input())
array = list()
array = list(map(int, input().split()))
increasing = list(0 for _ in range(N))
increasing[N-1] = 1
for i in range(N):
    increasing[i] = 1
    for j in range(0, i):
        if array[i] > array[j]:
            increasing[i] = max(increasing[i], increasing[j]+1)

print(max(increasing))
