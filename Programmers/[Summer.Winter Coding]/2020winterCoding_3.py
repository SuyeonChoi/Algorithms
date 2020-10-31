from collections import deque


def bfs(i, j, vis, map, n):
    queue = deque()
    queue.append((i, j))
    vis[i][j] = 1
    category = map[i][j]
    while queue:
        x, y = queue.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if vis[nx][ny] != 0 or map[nx][ny] != category:
                continue
            vis[nx][ny] = 1
            queue.append((nx, ny))
    return vis


def solution(v):
    n = len(v)
    visited = [[0]*n for _ in range(n)]
    answer = [0] * 3

    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                visited = bfs(i, j, visited, v, n)
                if v[i][j] == 0:
                    answer[0] += 1
                elif v[i][j] == 1:
                    answer[1] += 1
                else:
                    answer[2] += 1

    return answer

print(solution([[0,0,1,1],[1,1,1,1],[2,2,2,1],[0,0,0,2]]))