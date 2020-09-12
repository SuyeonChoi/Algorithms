import datetime
from operator import itemgetter

def calc(start, end):
    tmp = end - start
    hour = tmp // 3600
    tmp = tmp % 3600
    min = tmp // 60
    sec = tmp % 60
    return hour, min, sec

def solution(play_time, adv_time, logs):
    answer = ''
    points = []
    a = adv_time.split(':')
    for p in logs:
        p = p.split('-')
        points.append((p[0], p[1]))
    points = sorted(points, key=itemgetter(0))
    accumulation = []
    print(points)
    for i in range(len(points)):
        start = points[i][0].split(':')
        end = [int(start[0])+int(a[0]), int(start[1])+int(a[1]), int(start[2])+int(a[2])]
        if end[1] >= 60:
            end[0] += 1
            end[1] -= 60
        if end[2] >= 60:
            end[1] += 1
            end[2] -= 60
        print(start)
        start = int(start[0]) * 3600 + int(start[1]) * 60 + int(start[2])
        end = int(end[0]) * 3600 + int(end[1]) * 60 + int(end[2])
        time = [0, 0, 0]
        for t1, t2 in points:
            t1 = t1.split(':')
            t1 = int(t1[0]) * 3600 + int(t1[1]) * 60 + int(t1[2])
            t2 = t2.split(':')
            t2 = int(t2[0]) * 3600 + int(t2[1]) * 60 + int(t2[2])
            if t1 <= start:
                if t2 > start and t2 <= end:
                    h, m, s = calc(start, t2)
                    time[0] += h
                    time[1] += m
                    time[2] += s
                elif t2 > end:
                    h, m, s = calc(start, t2)
                    time[0] += h
                    time[1] += m
                    time[2] += s
            elif start < t1 and t1 <= end:
                if t2 <= end:
                    h, m, s = calc(start, t2)
                    time[0] += h
                    time[1] += m
                    time[2] += s
                else:
                    h, m, s = calc(start, t2)
                    time[0] += h
                    time[1] += m
                    time[2] += s
        if time[2] >= 60:
            time[1] += (time[2]//60)
            time[2] += (time[2] % 60)
        if time[1] >= 60:
            time[0] += (time[1]//60)
            time[1] += (time[1] % 60)
        accumulation.append(time)


    # print(points)
    return answer


print(solution("99:59:59", "25:00:00", ["69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"]))