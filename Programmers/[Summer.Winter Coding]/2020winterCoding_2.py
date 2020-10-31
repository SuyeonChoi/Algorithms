def solution(encrypted_text, key, rotation):
    encrypted_text = list(encrypted_text)
    key = list(key)
    if rotation < 0:
        for i in range(abs(rotation)):
            encrypted_text.insert(0, encrypted_text.pop())
    else:
        for i in range(rotation):
            encrypted_text.append(encrypted_text.pop(0))
    answer = ''
    for t, k in zip(encrypted_text, key):
        calc = ord(t) - (ord(k)-96)
        if calc < 96:
            calc += 26
        answer += chr(calc)
    return answer

print(solution("qyyigoptvfb", "abcdefghijk", 3))