def solution(participant, completion):
    runners = {}
    for i in range(len(participant)):
        if participant[i] in runners:
            runners[participant[i]] += 1
        else:
            runners[participant[i]] = 1
    for i in range(len(completion)):
        if completion[i] in runners:
            runners[completion[i]] -= 1
    answer = ''
    for i in range(len(participant)):
        if participant[i] in runners:
            if runners[participant[i]] != 0:
                answer = participant[i]
                break

    return answer