#reduce

from functools import reduce

def suma(x,y):
    print("x: " + str(x) + ", y: " + str(y))
    return x + y


lista = [1,2,3,4,5]

soma = reduce(suma,lista)
