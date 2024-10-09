# 1부터 30까지의 출석번호를 모두 포함한 집합
all_students = set(range(1, 31))

# 제출한 학생 번호를 입력받아 집합으로 저장
submitted_students = set(int(input()) for _ in range(28))

# 제출하지 않은 학생은 차집합으로 구함
missing_students = sorted(all_students - submitted_students)

# 제출하지 않은 학생 번호 출력
for student in missing_students:
    print(student)
