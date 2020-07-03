from collections import deque
import copy
N = int(input())
rgb = [list(input()) for _ in range(N)]
blind_rgb = copy.deepcopy(rgb)
for i in range(N):
    for j in range(N):
        if blind_rgb[i][j] == 'G':
            blind_rgb[i][j] = 'R'
normal = [[0]*N for _ in range(N)]
blind = [[0]*N for _ in range(N)]
normal_section = 0
blind_section = 0
for i in range(N):
    for j in range(N):
        #적록색약
        if blind[i][j] == 0:
            queue = deque()
            queue.append((i, j))
            blind[i][j] = 1
            blind_section += 1
            while queue:
                x, y = queue.popleft()
                color = blind_rgb[x][y]
                for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
                    nx, ny = dx + x, dy + y
                    if nx < 0 or nx >= N or ny < 0 or ny >= N:
                        continue
                    if blind_rgb[nx][ny] != color or blind[nx][ny] != 0:
                        continue
                    queue.append((nx, ny))
                    blind[nx][ny] = 1
        #적록색약이 아닌 사람
        if normal[i][j] == 0:
            queue = deque()
            queue.append((i, j))
            normal[i][j] = 1
            normal_section += 1
            while queue:
                x, y = queue.popleft()
                color = rgb[x][y]
                for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
                    nx, ny = dx + x, dy + y
                    if nx < 0 or nx >= N or ny < 0 or ny >= N:
                        continue
                    if rgb[nx][ny] != color or normal[nx][ny] != 0:
                        continue
                    queue.append((nx, ny))
                    normal[nx][ny] = 1

print(normal_section, blind_section)