def solution(new_id):
    #step1
    id = list(new_id.lower())

    #step2
    i = 0
    while i < len(id):
        s = id[i]
        if not s.isalpha() and not s.isnumeric() and s not in ['-', '_', '.']:
            id.pop(i)
            continue
        i += 1

    #step3
    i = 1
    while i < len(id):
        s = id[i]
        if id[i] == '.' and id[i-1] == '.':
            id.pop(i-1)
            continue
        i += 1

    # step4
    if id[0] == '.':
        id.pop(0)
    if id and id[-1] == '.':
        id.pop()

    # step5
    if len(id) == 0:
        id.append('a')
    # step6
    if len(id) >= 16:
        id = id[:15]
        if id[-1] == '.':
            id.pop()

    # step7
    if len(id) <= 2:
        last = id[-1]
        expand = [last*(3-len(id))]
        id = id + expand
    return ''.join(id)

print(solution("...!@BaT#*..y.abcdefghijklm"))