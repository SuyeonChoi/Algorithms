import heapq
def solution(jobs):
    total = 0
    length = len(jobs)
    disk = []
    time = 0
    while jobs:
        duration = []
        index = []
        for j in jobs:
            if j[0] <= time:
                index.append(j[0])
                duration.append(j[1])
        if not index:
            time += 1
            continue
        d = min(duration)
        i = index[duration.index(d)]
        disk.append((i, d))
        time += d
        jobs.remove([i, d])
        total += (time - i)
    return total // length
print(solution([[0, 3], [1, 9], [2, 6]]	))





