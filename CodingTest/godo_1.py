#핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
class Solution:
    def solution(self, goods):
        pay, tmp = 0, 0
        for product in goods:
            if product >= 50:
                pay += (product - 10)
            else:
                tmp += product

        if tmp >= 50:
            pay += (tmp - 10)
        else:
            pay += tmp
        return pay