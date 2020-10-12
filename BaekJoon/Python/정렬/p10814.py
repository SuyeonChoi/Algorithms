import sys
input = sys.stdin.readline
N = int(input())
people = dict()
for i in range(N):
    age, name = map(str, input().split())
    if int(age) in people:
        people[int(age)].append(name)
    else:
        people[int(age)] = [name]
people = sorted(people.items())
for i in range(len(people)):
    age = people[i][0]
    for j in range(len(people[i][1])):
        print(age, people[i][1][j])