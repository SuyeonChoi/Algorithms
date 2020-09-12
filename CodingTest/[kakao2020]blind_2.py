from itertools import combinations

def solution(orders, course):
    #가장 많이 주문된 단품메뉴 조합 구하기
    course_menu = []
    for num in course:
        menu_dict = dict()
        for order in orders:
            pair_list = list(combinations(order, num))
            for pair in pair_list:
                pair = "".join(sorted([str(s) for s in pair]))
                if pair in menu_dict.keys():
                    menu_dict[pair] += 1
                else:
                    menu_dict[pair] = 1
        if len(menu_dict) == 0:
            continue
        _max = max(menu_dict.values())
        for c in menu_dict.keys():
            if menu_dict[c] == _max and _max != 1:
                course_menu.append("".join([str(s) for s in c]))
        # print(menu_dict)
        course_menu.sort()
        # print(course_menu)
    return course_menu


print(solution( ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2, 3, 5]))