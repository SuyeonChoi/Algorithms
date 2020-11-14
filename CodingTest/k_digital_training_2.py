def isRight(paren):
    stack = []
    for c in paren:
        if c == '(':
            stack.append(c)
        else:
            if len(stack) == 0:
              return 0
            stack.pop()
    if stack:
        return 0
    return 1


def solution(arr1, arr2):
    answer = 0
    for first in arr1:
        for sec in arr2:
            if isRight(list(first+sec)):
                answer += 1

    # arr1_right, arr1_wrong, arr2_right, arr2_wrong = [], [], [], []
    # for par in arr1:
    #     if isRight(list(par)):
    #         arr1_right.append(par)
    #     else:
    #         arr1_wrong.append(par)
    # for par in arr2:
    #     if isRight(list(par)):
    #         arr2_right.append(par)
    #     else:
    #         arr2_wrong.append(par)
    # answer = len(arr1_right)*len(arr2_right)
    # for first in arr1_wrong:
    #     for sec in arr2_wrong:
    #         if isRight(list(first+sec)):
    #             answer += 1
    # print(arr1_right)
    # print(arr1_wrong)
    # print(arr2_right)
    # print(arr1_wrong)

    return answer

print(solution(["()", "(()", ")()", "()"], [")()", "()", "(()"]))