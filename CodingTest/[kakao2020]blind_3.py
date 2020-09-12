def solution(info, query):
    table = []
    command = []
    answer = []

    for i in info:
        i = i.split(' ')
        table.append(i)
    print(table)
    for q in query:
        q = q.replace('and ', '')
        q = q.split(' ')
        command.append(q)


        net = []
        print(q)
        for i in range(len(table)):
            if (table[i][0] == q[0] or q[0] == '-') and \
                    (table[i][1] == q[1] or q[1] == '-') and \
                    (table[i][2] == q[2] or q[2] == '-') and \
                    (table[i][3] == q[3] or q[3] == '-') and \
                    (int(table[i][4]) >= int(q[4]) or q[4] == '-'):
                net.append(table[i])
        # print(net)
        answer.append(len(net))

    return answer

print(solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"],
               ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]))