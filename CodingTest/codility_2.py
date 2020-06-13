def solution(S):
    # write your code in Python 3.6
    code = list(S)
    a = len(S)
    i = 0
    initialize = 0
    while True:
        if initialize >= len(code) - 1:
            break
        while True:
            if i >= len(code) - 1:
                i = initialize
                break
            if code[i] == 'A' and code[i + 1] == 'A':
                del code[i]
                del code[i]
                continue
            i += 1
        while True:
            if i >= len(code) - 1:
                i = initialize
                break
            if code[i] == 'B' and code[i + 1] == 'B':
                del code[i]
                del code[i]
                continue
            i += 1
        while True:
            if i >= len(code) - 1:
                i = initialize
                break
            if code[i] == 'C' and code[i+1] == 'C':
                del code[i]
                del code[i]
                continue
            i += 1
        initialize += 1
    if len(code) == 2 and code[0] == code[1]:
        return ''
    return ''.join((code))

print(solution('ACCAABBC'))
print(solution('ABCBBCBA'))
print(solution('BABABA'))
