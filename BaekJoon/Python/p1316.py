N = int(input())
count = 0
for i in range(N):
    word = list(input())
    alphabets = [word[0]]
    for j in range(1, len(word)):
        if word[j] != word[j-1] and word[j] not in alphabets:
            alphabets.append(word[j])
        elif word[j] != word[j-1] and word[j] in alphabets:
            count += 1
            break

print(N-count)

