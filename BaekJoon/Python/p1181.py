N = int(input())
dic = {}
word_list = list()
for i in range (N):
    word = input()
    if len(word) in dic:
        if word not in dic[len(word)]:
            dic[len(word)].append(word)
            dic[len(word)] = sorted(dic[len(word)])
    else:
        dic[len(word)] = [word]

dic = sorted(dic.items())
for i in range(len(dic)):
    for j in range(len(dic[i][1])):
        print(dic[i][1][j])


