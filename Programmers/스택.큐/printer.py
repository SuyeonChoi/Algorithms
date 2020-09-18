def solution(priorities, location):
    docs = []
    for i in range(len(priorities)):
        docs.append(chr(ord('A') + i))
    target = docs[location]
    result = []
    while priorities:
        if priorities[0] >= max(priorities):
            priorities.pop(0)
            result.append(docs.pop(0))
        else:
            priorities.append(priorities.pop(0))
            docs.append(docs.pop(0))
    answer = result.index(target) + 1

    return answer

print(solution([1, 1, 9, 1, 1, 1]	, 0))

