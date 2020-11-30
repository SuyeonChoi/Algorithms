# #핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
# class Solution:
#     def solution(self, cardNumber):
#         numList = list(map(int, list(cardNumber)))
#         _sum = 0
#
#         #숫자가 홀수 개수 존재
#         if len(numList) % 2:
#             for i in range(0, len(numList), 2):
#                 numList[i] *= 2
#         else:
#             for i in range(1, len(numList), 2):
#                 numList[i] *= 2
#         for num in numList:
#             if num >= 10:
#                 num = list(str(num))
#                 _sum += (int(num[0]) + int(num[1]))
#             else:
#                 _sum += num
#         if _sum % 10:
#             return "INVALID"
#         return "VALID"

def solution(cardNumber):
    numList = list(map(int, list(cardNumber)))
    _sum = 0
    #숫자가 홀수 개수 존재
    if len(numList) % 2:
        for i in range(1, len(numList), 2):
            numList[i] *= 2
    else:
        for i in range(0, len(numList), 2):
            numList[i] *= 2
    print(numList)
    for num in numList:
        if num >= 10:
            num = list(str(num))
            _sum += (int(num[0]) + int(num[1]))
        else:
            _sum += num
    print(_sum)
    if _sum % 10:
        return "INVALID"
    return "VALID"

print(solution("21378"))