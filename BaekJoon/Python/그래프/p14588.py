N = int(input())
friends = [tuple(map(int, input().split())) for _ in range(N)]
d = [[N+1]*N for _ in range(N)]
for i in range(N):
    x1, x2 = friends[i]
    for j in range(N):
        if i == j:
            continue
        y1, y2 = friends[j]
        if (x1 <= y1 and x2 > y1):
            d[i][j] = 1
            d[j][i] = 1
        elif (x1 < y2 and x2 >= y2):
            d[i][j] = 1
            d[j][i] = 1
        elif (y1 <= x1 and x2 <= y2):
            d[i][j] = 1
            d[j][i] = 1
        elif x2 == y1 or x1 == y2:
            d[i][j] = 1
            d[j][i] = 1

for k in range(N):
    for i in range(N):
        for j in range(N):
            d[i][j] = min(d[i][j], d[i][k]+d[k][j])

Q = int(input())
for i in range(Q):
    x, y = map(int, input().split())
    if d[x-1][y-1] != N+1:
        print(d[x-1][y-1])
    else:
        print(-1)
