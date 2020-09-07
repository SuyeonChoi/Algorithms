def solution(genres, plays):
    answer = []
    total = dict()
    for i in range(len(genres)):
        if genres[i] in total:
            total[genres[i]][0] += int(plays[i])
            total[genres[i]].append(plays[i])
        else:
            total[genres[i]] = [plays[i]]
            total[genres[i]].append(plays[i])
    print(total)
    ascending = sorted(total.keys(), key=lambda x: x[1])
    print(ascending)
    # for p1, p2 in zip(genres, plays):

    return answer

print(solution(["classic", "pop", "adf","classic"], [500, 700, 600, 150]))