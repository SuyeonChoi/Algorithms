import sys
input = sys.stdin.readline
N = int(input())
students = [[] for _ in range(N)]
for i in range(N):
    name, korean, english, math = map(str, input().split())
    students[i] = [name, int(korean), int(english), int(math)]

students.sort(key=lambda x:(-x[1], x[2], -x[3], x[0]))
for s in students:
    print(s[0])
