N = int(input())
arr = []
ans = []
for i in range(N):
    x, y = map(int, input().split())
    arr.append([x, y])
arr = sorted(arr, key=lambda x: -x[0])


print(arr)
