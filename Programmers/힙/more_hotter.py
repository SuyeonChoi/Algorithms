from collections import deque
import heapq
def solution(scoville, K):
    heapq.heapify(scoville)
    cnt = 0
    while len(scoville) >= 2:
        # print(scoville)
        s1 = heapq.heappop(scoville)
        if s1 >= K:
            return cnt
        else:
            s2 = heapq.heappop(scoville)
            heapq.heappush(scoville, s1 + (s2*2))
            cnt += 1
    if scoville and scoville[0] >= K:
        return cnt
    return -1

print(solution([7]		, 7))

