while True:
    a, b, c = map(int, input().split())

    if a == 0 and b == 0 and c == 0:
         break

    if a + b <= c:
        print("Invalid")
    elif a == b and b == c:
        print("Equilateral")
    elif a == b or b == c or c == a:
        print("Isosceles")
    else:
        print("Scalene")