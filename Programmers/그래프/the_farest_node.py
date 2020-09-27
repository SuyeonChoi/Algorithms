from collections import deque


def bfs(n, adj):
    visited = [-1] * (n+1)
    queue = deque()
    queue.append(1)
    visited[1] = 0
    while queue:
        cur = queue.popleft()
        for v in range(len(adj[cur])):
            nxt = adj[cur][v]
            if visited[nxt] == -1:
                visited[nxt] = visited[cur] + 1
                queue.append(nxt)
    return visited

def solution(n, edge):
    v, e = n, len(edge)
    adj = [[] for _ in range(v+1)]
    for e in edge:
        adj[e[0]].append(e[1])
        adj[e[1]].append(e[0])
    length = bfs(n, adj)
    _max = max(length)
    answer = 0
    for l in length:
        if l == _max:
            answer += 1
    return answer

print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	))