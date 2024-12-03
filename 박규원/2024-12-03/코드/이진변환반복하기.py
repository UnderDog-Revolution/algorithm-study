def solution(s):
    countBinaryChange = 0 # 이진 변환 횟수
    countRemoveZero = 0 # 제거할 0의 개수
    result=s # 이진 변환 결과
    answer = []
    
    # 1. 0 제거 후 길이 구하기
    # 2. 1번의 이진변환 진행
    # 3. 위 1,2번을 이진 변환결과가 "1"이 될때 까지 반복
    while result!='1':
        countRemoveZero += countZero(result)
        result = changeToBinary(removeZero(result))
        countBinaryChange+=1

    answer.append(countBinaryChange)
    answer.append(countRemoveZero)
    return answer

#0 제거 후 길이 반환
def removeZero(binary):
    countOne=0
    for i in binary:
        if(i=="1"):
            countOne+=1
    
    return countOne

#제거할 0의 개수 파악(총 0의 개수)
def countZero(binary):
    count=0
    for i in binary:
        if(i=="0"):
            count+=1
            
    return count

#이진 변환 결과
def changeToBinary(countOne):
    num = "" 
    while countOne!=1:
        num = str(countOne%2)+num
        countOne=countOne//2
    num = "1"+num
    
    return num    