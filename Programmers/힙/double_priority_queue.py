from collections import deque
def solution(operations):
    queue = deque()
    while operations:
        command, num = operations.pop(0).split()
        if command == 'I':
            queue.append(int(num))
        else:
            if len(queue) == 0:
                continue
            if num == '1':
                queue.remove(max(queue))
            else:
                queue.remove(min(queue))
    if queue:
        return [max(queue), min(queue)]
    return [0, 0]


print(solution(	["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))