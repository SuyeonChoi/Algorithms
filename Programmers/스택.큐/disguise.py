def solution(clothes):
    answer = 1
    disguise = dict()
    for i in clothes:
        category = i[1]
        if category in disguise:
            disguise[category] += 1
        else:
            disguise[category] = 1
    for i in disguise.values():
        answer *= (i + 1)
    return answer - 1

print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))