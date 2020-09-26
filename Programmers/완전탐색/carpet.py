def solution(brown, yellow):
    answer = []
    num = 1
    yellow_pair = []
    while yellow:
        if yellow % num == 0 and num <= yellow // num:
            yellow_pair.append((num, yellow // num))
        num += 1
        if num >= yellow:
            break
    brown_pair = []
    for i in range(len(yellow_pair)):
        x, y = yellow_pair[i][0], yellow_pair[i][1]
        while x*y-yellow < brown:
            x += 2
            y += 2
        if x * y == brown + yellow:
            return [y, x]
    return answer

print(solution(24, 24))
