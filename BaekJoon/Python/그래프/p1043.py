from collections import deque


def bfs(wise, graph):
    visited = [0] * (N+1)
    for i in wise:
        if visited[i] == 1:
            continue
        queue = deque([i])
        visited[i] = 1
        while queue:
            cur = queue.popleft()
            for nxt in graph[cur]:
                if visited[nxt] == 0:
                    visited[nxt] = 1
                    queue.append(nxt)
    known = []
    for i in range(len(visited)):
        if visited[i] == 1:
            known.append(i)
    return known



N, M = map(int, input().split())
wise = list(map(int, input().split()))[1:]
graph = [[] for _ in range(N+1)]
party = []
for i in range(M):
    tmp = list(map(int, input().split()))
    party.append(tmp[1:])
    for j in range(1, tmp[0]):
        if tmp[j] not in graph[tmp[j+1]]:
            graph[tmp[j]].append(tmp[j+1])
            graph[tmp[j+1]].append(tmp[j])
connection = bfs(wise, graph)
# print(connection)
cnt = 0
for people in party:
    check = 1
    for p in people:
        if p in connection:
            check = 0
            break
    if check:
        cnt += 1
print(cnt)
