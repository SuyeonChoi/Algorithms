import math

def solution(progresses, speeds):
    stack = []
    while progresses:
        stack.append(math.ceil((100 - progresses.pop(0)) / speeds.pop(0)))
    print(stack)
    answer = []
    while stack:
        left = stack.pop(0)
        cnt = 1
        while stack and stack[0] <= left:
            stack.pop(0)
            cnt += 1
        answer.append(cnt)
    return answer
