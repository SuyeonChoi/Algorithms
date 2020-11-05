def solution(numbers):
    numbers.sort()
    answer = [numbers[0]+numbers[1]]
    for i in range(0, len(numbers)):
        for j in range(i+1, len(numbers)):
            tmp = numbers[i] + numbers[j]
            if tmp not in answer:
                answer.append(tmp)
    answer.sort()
    return answer

print(solution([2,1,3,4,1]))