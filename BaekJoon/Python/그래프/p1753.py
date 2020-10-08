import heapq, sys
input = sys.stdin.readline
V, E = map(int, input().split())
K = int(input())
INF = 100000000
adj = [[] for _ in range(V+1)]
d = [INF] * (V+1)
for i in range(E):
    a, b, c = map(int, input().split())
    adj[a].append((b, c))

def dijkstra():
    pq = []
    d[K] = 0
    heapq.heappush(pq, (d[K], K))
    while pq:
        dist, idx = heapq.heappop(pq)
        if dist != d[idx]:
            continue
        for nxt in adj[idx]:
            nidx, cost = nxt
            if dist+cost < d[nidx]:
                d[nidx] = dist+cost
                heapq.heappush(pq, (d[nidx], nidx))
    return d


result = dijkstra()
for i in range(1, len(result)):
    if result[i] == INF:
        print('INF')
    else:
        print(result[i])