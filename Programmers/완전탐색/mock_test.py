def solution(answers):
    answer = []
    #길이 5, 8, 10
    one = [1, 2, 3, 4, 5]
    two = [2, 1, 2, 3, 2, 4, 2, 5]
    three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    result = [0, 0, 0]
    for i in range(len(answers)):
        one_idx = i % 5
        two_idx = i % 8
        three_idx = i % 10
        if one[one_idx] == answers[i]:
            result[0] += 1
        if two[two_idx] == answers[i]:
            result[1] += 1
        if three[three_idx] == answers[i]:
            result[2] += 1
    maxScore = max(result)
    for i in range(len(result)):
        if result[i] == maxScore:
            answer.append(i+1)
    return answer

print(solution([1,3,2,4,2]	))