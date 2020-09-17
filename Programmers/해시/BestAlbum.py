def solution(genres, plays):
    _sum = dict()
    category = dict()
    for g, p in zip(genres, plays):
        if g in _sum:
            _sum[g] += p
            category[g].append(p)
        else:
            _sum[g] = p
            category[g] = [p]
    priority = sorted(_sum.items(), key=lambda x: x[1], reverse=True)
    for i in category.keys():
        category[i].sort(reverse=True)
        if len(category[i]) > 2:
            category[i] = category[i][:2]

    answer = []
    for i in priority:
        for j in category.keys():
            if j == i[0]:
                answer = answer + category[j]
    for i in range(len(answer)):
        idx = plays.index(answer[i])
        answer[i] = idx
        plays[idx] = -1
    return answer