from collections import deque

def solution(n, computers):
    answer = 0
    visited = [0] * len(computers)
    for i in range(n):
        check = 0
        for j in visited:
            if j == 0:
                check = 1
        if check == 0:
            break
        if visited[i] == 1:
            continue
        queue = deque()
        queue.append(i)
        visited[0] = 1
        while queue:
            idx = queue.popleft()
            for i in range(n):
                if computers[idx][i] == 1 and visited[i] == 0:
                    visited[i] = 1
                    queue.append(i)
        answer += 1
    return answer

print(solution(3,[[1, 1, 0], [1, 1, 1], [0, 1, 1]]))