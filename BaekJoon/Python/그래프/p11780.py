n = int(input())
m = int(input())
INF = 100000000
d = [[INF]*(n+1) for _ in range(n+1)]
nxt = [[0]*(n+1) for _ in range(n+1)]

for i in range(m):
    a, b, c = map(int, input().split())
    d[a][b] = min(d[a][b], c)
    nxt[a][b] = b
for i in range(1, n+1):
    d[i][i] = 0

for k in range(1, n+1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if d[i][j] > d[i][k]+d[k][j]:
                d[i][j] = d[i][k]+d[k][j]
                nxt[i][j] = nxt[i][k]

for i in range(1, n+1):
    for j in range(1, n+1):
        if d[i][j] == INF:
            print(0, end=' ')
        else:
            print(d[i][j], end=' ')
    if i == n:
        break
    print()

for i in range(1, n+1):
    for j in range(1, n + 1):
        if nxt[i][j] == 0:
            print(0)
        else:
            path = []
            cur = i
            while cur != j:
                path.append(cur)
                cur = nxt[cur][j]
            path.append(cur)
            print(len(path), ' '.join(map(str, path)))
