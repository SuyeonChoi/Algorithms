from collections import deque
def solution(prices):
    answer = []
    prices = deque(prices)
    while prices:
        tmp = prices.popleft()
        time = 0
        for i in prices:
            if i >= tmp:
                time += 1
            else:
                time += 1
                break
        answer.append(time)
    return answer