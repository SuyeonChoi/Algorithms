import sys
import copy
from collections import deque
input = sys.stdin.readline
R, C = map(int, input().split())
lake = []
visited = [[-1]*C for _ in range(R)]
queue = deque()
swan = list()
for i in range(R):
    tmp = list(input())[:-1]
    lake.append(tmp)
    for j in range(C):
        if tmp[j] == '.':
            visited[i][j] = 0
            queue.append((i, j))
        if tmp[j] == 'L':
            visited[i][j] = 0
            swan.append((i, j))
            queue.append((i, j))


def iceBFS():
    finalDay = 0
    while queue:
        x, y = queue.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >=R or ny < 0 or ny >= C:
                continue
            if visited[nx][ny] != -1:
                continue
            queue.append((nx, ny))
            visited[nx][ny] = visited[x][y] + 1
            finalDay = visited[nx][ny]
    return finalDay

def swanBFS(mid):
    swanQueue = deque()
    swanQueue.append((swan[0][0], swan[0][1]))
    visitedSwan = [[0] * C for _ in range(R)]
    visitedSwan[swan[0][0]][swan[0][1]] = 1
    while swanQueue:
        x, y = swanQueue.popleft()

        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= R or ny < 0 or ny >= C:
                continue
            if visitedSwan[nx][ny] != 0 or visited[nx][ny] > mid:
                continue
            if nx == swan[1][0] and ny == swan[1][1]:
                return True
            swanQueue.append((nx, ny))
            visitedSwan[nx][ny] = 1
    return False

high = iceBFS()
low = 0
# for i in range(R):
#     print(visited[i])
answer = high

while low <= high:
    mid = (low + high) // 2
    if swanBFS(mid):
        answer = mid
        high = mid - 1
    else:
        low = mid + 1
print(answer)


