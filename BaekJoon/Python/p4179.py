from collections import deque
from sys import stdin

input = stdin.readline
R, C = map(int, input().split())
maze = list()
queue = deque()
queue2 = deque()
fire = [[-1] * C for _ in range(R)]
escape = [[-1] * C for _ in range(R)]
for i in range(R):
    line = list(input())
    for j in range(C):
        if line[j] == 'F':
            queue.append((i, j))
            fire[i][j] = 0
        elif line[j] == 'J':
            queue2.append((i, j))
            escape[i][j] = 0
    maze.append(line)

def bfs():
    global queue
    while queue:
        x, y = queue.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = dx + x, dy + y
            if nx < 0 or nx >= R or ny < 0 or ny >= C or maze[nx][ny] == '#' or fire[nx][ny] >= 0:
                continue
            if fire[nx][ny] == -1 and maze[nx][ny] != '#':
                queue.append((nx, ny))
                fire[nx][ny] = fire[x][y] + 1
    global queue2
    while queue2:
        x, y = queue2.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = dx + x, dy + y
            if nx < 0 or nx >= R or ny < 0 or ny >= C:
                print(escape[x][y] + 1)
                return
            if fire[nx][ny] != -1 and fire[nx][ny] <= escape[x][y] + 1:
                continue
            if escape[nx][ny] == -1 and maze[nx][ny] != '#':
                queue2.append((nx, ny))
                escape[nx][ny] = escape[x][y] + 1
    print('IMPOSSIBLE')

bfs()