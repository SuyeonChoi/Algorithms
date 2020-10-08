import heapq
cnt = 1
while True:
    N = int(input())
    if N == 0:
        break
    INF = 10000000000
    adj = [[] for _ in range(N*N)]
    cave = [list(map(int, input().split())) for _ in range(N)]
    d = [INF] * (N*N)
    for i in range(N*N):
        if (i-1) // N == i // N and i != 0: #left
            adj[i].append((i-1, cave[i//N][(i-1)%N]))
        if (i+1) // N == i // N: #right
            adj[i].append((i + 1, cave[i // N][(i + 1) % N]))
        if i-N >= 0: #up
            adj[i].append((i - N, cave[i//N - 1][i % N]))
        if i + N < N*N: #down
            adj[i].append((i + N, cave[i//N+1][i % N]))
    d[0] = cave[0][0]
    pq = []
    heapq.heappush(pq, (d[0], 0))
    while pq:
        dist, idx = heapq.heappop(pq)
        if d[idx] != dist:
            continue
        for nxt in adj[idx]:
            nidx, cost = nxt
            if cost + dist < d[nidx]:
                d[nidx] = cost + dist
                heapq.heappush(pq, (d[nidx], nidx))
    print(f'Problem {cnt}:',d[N*N-1])
    cnt += 1