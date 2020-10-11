def solution(numbers, hand):
    answer = ''
    cur_left = 10
    cur_right = 12
    for n in numbers:
        if n == 0:
            n = 11
        if n == 1 or n == 4 or n == 7:
            answer += 'L'
            cur_left = n
        elif n == 3 or n == 6 or n == 9:
            answer += 'R'
            cur_right = n
        else:
            if cur_right in [3, 6, 9, 12]:
                dist_right = abs((n+1)-cur_right) // 3 + 1
            else:
                dist_right = abs(n-cur_right) // 3
            if cur_left in [1, 4, 7, 10]:
                dist_left = abs((n-1)-cur_left) // 3 + 1
            else:
                dist_left = abs(n - cur_left) // 3
            if dist_right < dist_left:
                answer += 'R'
                cur_right = n
            elif dist_right > dist_left:
                answer += 'L'
                cur_left = n
            else:
                if hand == 'right':
                    answer += 'R'
                    cur_right = n
                else:
                    answer += 'L'
                    cur_left = n
    return answer
